pipeline {
    agent any 
    tools {
        maven "MAVEN-3.9.2"
        jdk "ORACELJDK11"

    }

    stages {
        stage('fetch code'){
            steps {
                git branch :  'main' , url: 'https://github.com/karamFci/nexjen.git'
            }
        }
        stage('Docker Build') {
    	    agent any
            steps {
      	      sh 'docker build -t karamfci/my25nginx:v1 .'
      }
    }

    }
}