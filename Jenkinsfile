pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
          PATH = "/usr/local/bin:${env.PATH}"
          DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
          DOCKERHUB_REPO = 'saileshk1103/OTP1_inclass_assignment'
          DOCKER_IMAGE_TAG = 'v1'
    }

    stages {

        stage('Checkout') {
            steps {
               git branch: 'main', url: 'https://github.com/SaileshK1103/OTP1_inclass_assignment.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Generate Report') {
            steps {
                sh 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

         stage('Build and Push Multi-Arch Image') {
             steps {
                 script {
                     withCredentials([usernamePassword(credentialsId: DOCKERHUB_CREDENTIALS_ID, usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                         // 1. Login is still required
                         sh "docker login -u ${USER} -p ${PASS}"

                         // 2. buildx creates the manifest for both AMD64 and ARM64
                         // The --push flag is required for multi-arch builds
                         sh "docker buildx build --platform linux/amd64,linux/arm64 -t ${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG} . --push"
                     }
                 }
             }
         }
    }
}