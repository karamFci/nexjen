pipeline {
  agent any
  
  stages {
    stage('Clone repository') {
      steps {
        git 'https://github.com/karamFci/nexjen.git'
      }
    }
    
    stage('Build Docker image') {
      steps {
        sh 'docker build -t my26ngix .'
      }
    }
    
    stage('Run Docker container') {
      steps {
        sh 'docker run -d -p 8888:80 my26nginx'
      }
    }
  }
  
//   post {
//     always {
//       script {
//         // Get the container's IP address
//         def ipAddress = sh(returnStdout: true, script: "docker inspect -f '{{ .NetworkSettings.IPAddress }}' my-nginx").trim()
        
//         // Print the container's IP address
//         echo "Docker container IP address: ${ipAddress}"
//       }
//     }
//   }
 }
