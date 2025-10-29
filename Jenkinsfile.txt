pipeline {
  agent any
  tools {
    maven 'Maven 3.9.9'
    // jdk 'JDK 21'  // only if you have that JDK defined in Manage Jenkins > Tools
  }
  options { timestamps() }
  triggers { githubPush() }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Test') {
      steps { sh 'mvn -B -q test' }
    }
  }

  post {
    always {
      junit 'target/surefire-reports/TEST-*.xml'
      archiveArtifacts artifacts: 'target/surefire-reports/**', onlyIfSuccessful: false
    }
  }
}
