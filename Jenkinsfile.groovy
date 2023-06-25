pipeline {
    agent none
    tools {
        maven "MAVEN-3.9.2"
        jdk "ORACELJDK11"

    }

    stages {
        stage('fetch code')
            steps {
                git branch :  'main' , url: 'https://github.com/karamFci/nexjen.git'
            }
        
        stage('Build'){
            steps{
                sh 'mvn install -DskipTests'
            }
            post{ 
                success {
                    echo 'Now Archiving...'
                }
            }
        }
    }
}