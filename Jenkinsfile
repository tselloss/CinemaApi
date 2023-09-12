pipeline {
    agent any

  tools {
         jdk 'jdk17'
        maven 'maven3'
    }

    stages {

        stage('Git Checkout') {
            steps {
                script {
                    git branch: 'main', url: 'https://github.com/tselloss/CinemaApi.git'
                }
            }
        }

        stage('Compile') {
            steps {
                script {
                    sh 'maven compile' 
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'maven package -DskipTests=true' 
                }
            }
        }

       
    }
}
