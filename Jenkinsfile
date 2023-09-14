pipeline {
    agent any
    
    tools{
        maven 'maven3'
        jdk 'jdk17'
    }
    
    environment {
        
        SCANNER_HOME= tool 'sonar-scanner'
    }

    stages {
        stage('Git Checkout ') {
            steps {
                git branch: 'main', url: 'https://github.com/tselloss/CinemaApi.git'
            }
        }
        
        stage('OWASP Dependency Check') {
            steps {
                dependencyCheck additionalArguments: ' --scan ./ ', odcInstallation: 'DC'
                    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }
        
        // stage('Trivy FS SCan') {
        //     steps {
        //         sh "trivy fs ."
        //     }
        // }
        
        stage('Sonarqube Analysis') {
            steps {
                
                withSonarQubeEnv('sonar'){
                  sh "${maven}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=jjj -Dsonar.projectName='jjj'"
    }
  }
}
               }
                
               
            }
        
        
        
