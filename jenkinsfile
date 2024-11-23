pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17'  // Adjust path to your Java installation
        MAVEN_HOME = 'C:\\Program Files\\Apache\\maven' // Adjust path to your Maven installation
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                git 'https://github.com/username/repository.git'
            }
        }

        stage('Build') {
            steps {
                // Run Maven build command to compile the application and create the .jar file
                script {
                    bat '''mvn clean install -DskipTests'''
                }
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the generated .jar file using PowerShell or cmd
                script {
                    bat '''java -jar target\\demo-0.0.1-SNAPSHOT.jar'''
                }
            }
        }
    }

    post {
        success {
            // Actions to perform after a successful build
            echo "Build and deployment successful!"
        }
        failure {
            // Actions to perform after a failed build
            echo "Build or deployment failed. Please check the logs."
        }
    }
}