pipeline {
  agent any

  environment {
    imageName = "my30nginx"
    registry = 'localhost:2022/'
    dockerImage = ''
  }

  stages {
    stage('Clone repository') {
      steps {
        git url: 'https://github.com/karamFci/nexjen.git', branch: 'master'
      }
    }

    stage('Build Docker image') {
      steps {
        script {
          try {
            dockerImage = sh 'docker build -t my30nginx .'
            echo "this is docker image" + ${dockerImage}
           // dockerImage.build()
          } catch (Exception e) {
            println "Error building Docker image: ${e.message}"
            error("Failed to build Docker image")
          }
        }
      }
    }

    stage('Run Docker container') {
      steps {
        script {
          try {
            sh 'docker run -d -p 80:80 dockerImage'

            dockerImage.run("-p 80:80 -d")
          } catch (Exception e) {
            println "Error running Docker container: ${e.message}"
            error("Failed to run Docker container")
          }
        }
      }
    }

    stage('Push to Nexus') {
      steps {
        script {
          try {
            docker.withRegistry('http://' + registry, 'nexus-credentials') {
              dockerImage.push("latest")
            }
          } catch (Exception e) {
            println "Error pushing Docker image to Nexus: ${e.message}"
            error("Failed to push Docker image to Nexus")
          }
        }
      }
    }
  }
}
