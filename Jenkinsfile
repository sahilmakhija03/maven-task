pipeline {
    agent any
    tools {
        maven 'sonarmaven' // Ensure this matches the Maven configuration in Jenkins
    }
    environment {
        SONAR_TOKEN = credentials('sonar-token') // Replace 'sonar-token' with your credentials ID for the SonarQube token
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17'
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') { // Ensure this matches your SonarQube configuration
                    bat"""
                    mvn clean verify sonar:sonar \
              -Dsonar.projectKey=maven-demo \
              -Dsonar.projectName='maven-demo' \
              -Dsonar.host.url=http://localhost:9000 \
              -Dsonar.token=sqp_0c9456f834dafc357cc9a17bcae5d138c6d1ad90
                    """
                }
            }
        }
        stage('JaCoCo') {
            steps {
                archiveArtifacts artifacts: 'target/site/jacoco/index.html', allowEmptyArchive: true
            }
        }
}
    }
    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
