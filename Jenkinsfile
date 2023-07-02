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

            sh 'docker build -t my30nginx .'
 

        }
      }
    }

    stage('Run Docker container') {
      steps {
        script {

            sh 'docker run -d -p 80:80 my30nginx'

        }
      }
    }

    stage('Push to Nexus') {
      steps {
        script {
          try {
            //docker.withRegistry('http://' + registry, 'nexus-credentials') {
             // my30nginx.push("latest")

            withCredentials([usernamePassword(credentialsId: '123123', passwordVariable: 'PSW', usernameVariable: 'USER')]){
              sh "echo ${PSW} | docker login -u ${USER} --password-stdin http://localhost:2022/"
              sh "docker push http://localhost:2022//my30nginx:${BUILD_NUMBER}"  

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
