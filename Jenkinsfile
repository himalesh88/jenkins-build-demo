pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Verify Tools') {
            steps {
                sh '''
                    java -version
                    mvn -version
                    python3 --version
                '''
            }
        }

        stage('Build Java Application') {
            steps {
                dir('java-app') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Run Java Application') {
            steps {
                sh 'java -jar java-app/target/java-app-1.0.0.jar'
            }
        }

        stage('Run Python Application') {
            steps {
                sh 'python3 python-app/app.py'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'java-app/target/*.jar', fingerprint: true
        }

        success {
            echo 'Jenkins build completed successfully.'
        }

        failure {
            echo 'Jenkins build failed. Review the Console Output for details.'
        }
    }
}