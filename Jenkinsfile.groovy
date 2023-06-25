// pipeline {
//     agent any 
//     tools {
//         maven "MAVEN-3.9.2"
//         jdk "ORACELJDK11"

//     }

//     stages {
//         stage('fetch code')
//             steps {
//                 git branch :  'main' , url: 'https://github.com/karamFci/nexjen.git'
//             }
        
//         stage('Build'){
//             steps{
//                 sh 'mvn install -DskipTests'
//             }
//             post{ 
//                 success {
//                     echo 'Now Archiving...'
//                 }
//             }
//         }
//     }
// }

pipeline {
	agent none
  stages {
  	stage('Maven Install') {
    	agent {
      	docker {
        	image 'maven:3.5.0'
        }
      }
      steps {
      	sh 'mvn clean install'
      }
    }
  }
}