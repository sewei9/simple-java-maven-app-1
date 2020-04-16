def STATUS = ['SUCCESS': 'good', 'FAILURE': 'danger', 'UNSTABLE': 'danger', 'ABORTED': 'danger']

pipeline {
    agent any
    
    options {
        skipDefaultCheckout true
    }
    tools {
        maven 'M2'
    }
    stages {
    stage ('Checkout SCM'){
        steps {
            dir(path: "${env.CODE_BASE_DIR}") {
                checkout(scm: scm, poll: true)
            }
        }
    }
    stage('Compile') {
        steps {
            dir(path: "${env.CODE_BASE_DIR}") {
                sh 'mvn clean'
            }
        }
    }
    stage('Package') {
      steps {
        dir(path: "${env.CODE_BASE_DIR}") {
          sh 'mvn package'
        }
      }
    }
  }
}  