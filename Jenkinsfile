pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        git branch: 'main', url: 'https://github.com/karamFci/nexjen.git' 
      }
    }

    stage('Build Docker Image') {
      steps {
        sh 'docker build -t nginx-app .'
      }
    }

    stage('Run Docker Container') {
      steps {
        sh 'docker run -d -p 80:80 --name nginx-container nginx-app'
      }
    }
  }
}
