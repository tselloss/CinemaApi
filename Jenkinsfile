pipeline {
    agent any
    tools{
        jdk  'jdk17'
        maven  'maven3'
    }    
    environment
    {
        SCANNER_HOME= tool 'sonar-scanner'
        SONARQUBE_IMAGE_NAME = 'sonarqube:latest'
        JENKINS_IMAGE_NAME = 'jenkins/jenkins'
    }
    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/tselloss/CinemaApi.git'
            }
        }
        
        stage('COMPILE') {
            steps {
                sh "mvn clean compile -DskipTests=true"
            }
        }

        stage('OWASP Dependency Check') {
            steps {
                dependencyCheck additionalArguments: ' --scan ./ ', odcInstallation: 'DC'
                    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }

        stage('File System Scan') {
            steps {
                sh "/var/jenkins_home/workspace/trivy fs ."
            }
        }

        stage('Sonarqube Image Scan') {
            steps {
                 sh "/var/jenkins_home/workspace/trivy repo https://github.com/SonarSource/docker-sonarqube.git"
            }
        }

        stage('Jenkins Image Scan') {
            steps {               
                sh "/var/jenkins_home/workspace/trivy image ${JENKINS_IMAGE_NAME}"
            }
        }
        
       stage('Sonarqube Analysis') {
            steps {
                withSonarQubeEnv('sonar'){
                sh '''$SCANNER_HOME/bin/sonar-scanner \
                -Dsonar.projectName=cinemaApi \
                -Dsonar.java.binaries=. \
                -Dsonar.host.url=https://1bf7-109-178-137-184.ngrok-free.app \
                -Dsonar.projectKey=cinemaApi'''
            }
        }
       }        

        //  stage('Docker Build & Push') {
        //     steps {
        //         script{                      
        //                 sh "docker login -u tselloss"
        //             }
        //         }
        //     }
        // }

         stage('Build') {
            steps {
                sh "mvn clean package -DskipTests=true"
            }
        }
        
   }
}

        
