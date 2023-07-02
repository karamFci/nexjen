// pipeline {
//   agent any
//   environment{
//     registryCredentials = "nexus-credentials"
//     registry = "localhost:2022/"

//   }
  
//   stages {
//     stage('Clone repository') {
//       steps {
//         git url: 'https://github.com/karamFci/nexjen.git' , branch: 'main'
//       }
//     }
    
//     stage('Build Docker image') {
//       steps {
//         sh 'docker build -t my30nginx .'
//       }
//     }
    
//     stage('Run Docker container') {
//       steps {
//         sh 'docker run -d -p 80:80 my30nginx'
//         //docker tag my30nginx <nexus-hostname>:<repository-port>/<image>:<tag>

//       }
//     }
//     stage('Push to Nexus') {
//       steps {
//         script {
//             docker.withRegistry('http://'+registry, registryCredentials) {
//               //def nexusImage = docker.image('my30nginx')
//               //nexusImage.push("${env.BUILD_NUMBER}")
//             dockerImage.push("latest")
//           }
//         }
//       }
//     }


//   }
  

// }

pipeline {
  agent any

  environment {
    registryCredentials = 'nexus-credentials'
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
          dockerImage = docker.build my30nginx
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
          docker.withRegistry('http://' + registry, 'nexus-credentials') {
          dockerImage.push("latest")
          }
        }
      }
    }

  }
}
