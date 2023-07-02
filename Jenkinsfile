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
          dockerImage = docker.build imageName
        }
      }
    }

    stage('Run Docker container') {
      steps {
        script {
          dockerImage.run("-p 80:80 -d")
        }
      }
    }

    stage('Push to Nexus') {
      steps {
        script {
          docker.withRegistry('http://'+registry, 'nexus-credentials') {
          dockerImage.push("latest")
          }
        }
      }
    }

  }
}
