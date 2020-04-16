def STATUS = ['SUCCESS': 'good', 'FAILURE': 'danger', 'UNSTABLE': 'danger', 'ABORTED': 'danger']

pipeline {
    agent any
    environment {
        REPOSITORY_NAME = "common-framework"
        CODE_BASE_DIR = "${WORKSPACE}/${REPOSITORY_NAME.toLowerCase()}"
        /*ARTIFACTORY_URL = "artifactory.build.ingka.ikea.com"
        ARTIFACT_NAME = "${REPOSITORY_NAME.toLowerCase()}_${BRANCH_NAME}_${BUILD_ID}"
        GCLOUD_SDK_PATH = "${CODE_BASE_DIR}/GoogleCloudSDK/google-cloud-sdk/bin"
        PATH = "$GCLOUD_SDK_PATH:$PATH"
        scannerHome = tool 'SonarQubeScanner v4.2.0.1873'*/
    }
    options {
        skipDefaultCheckout true
    }
    tools {
        maven 'M2'
    }
    stages {
        /* stage('Prepare Environment'){
            steps {

            }
        }
    } */
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
                /*container('maven'){
                    sh 'mvn compile -DskipTests'
                }*/
            }
        }
    }
    /*stage('Test') {
        steps {
            dir(path: "${env.CODE_BASE_DIR}") {
                sh 'mvn test'
                  /*container('maven'){
                    sh 'mvn test'
                }*/
            }
        }        
    }*/
    /*stage('Static Code Analysis') {
      steps {
        dir(path: "${env.CODE_BASE_DIR}") {
          withSonarQubeEnv('SonarQube Prod') {
           sh '${scannerHome}/bin/sonar-scanner -Dsonar.branch.name=release-to-dev -Dsonar.branch.target=master'
          }
        }
      }
    }*/
    stage('Package') {
      steps {
        dir(path: "${env.CODE_BASE_DIR}") {
          sh 'mvn package'
          /*container('maven'){
           sh 'mvn package'
          }*/
        }
      }
    }
     /* stage('Deploy To GCP') {
       when {
         anyOf {
         branch "master";
         branch "release-to-*"
         }
       }
      steps {
        
      } */  
  }
}  
