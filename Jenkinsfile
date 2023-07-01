pipeline {
  agent any
  
  stages {
    stage('Clone repository') {
      steps {
        git url: 'https://github.com/karamFci/nexjen.git' , branch: 'main'
      }
    }
    
    stage('Build Docker image') {
      steps {
        sh 'docker build -t my30nginx .'
      }
    }
    
    stage('Run Docker container') {
      steps {
        sh 'docker run -d -p 80:80 my30nginx'
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
