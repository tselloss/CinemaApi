pipeline {
  agent any
  stages {
    stage('Git Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/tselloss/CinemaApi.git'
      }
    }
     stage('UNIT Testing') {
      steps {
         withMaven(maven: 'Maven') {
             sh 'mvn test'
        }       
      }
    }
  }
}
