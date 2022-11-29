pipeline {
    agent any

    tools {
        maven "Maven 3.8.6"
    }

    stages {
        stage ("Building Application") {
            steps {
                echo "Using Maven Install"
                dir("library-operations-loan-example/one-library-operations-example") {
                    sh "mvn install"    
                }
            }
        }
        stage ("Create Docker Image") {
            steps {
                echo "Creating a Docker Image"
                dir("library-operations-loan-example/one-library-operations-example") {
                    sh "docker build -t libraryoperations ."    
                }
            }
        }
        stage ("Create Docker Container") {
            steps {
                echo "Creating a Docker Container"
                dir("library-operations-loan-example/one-library-operations-example") {
                    sh "docker container create -p 8081:8081 --name LibraryOperations --net libraryconnect -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 libraryoperations"
                }
            }
        }
    }
    post {
        success {
            echo "LibraryOperations successful created"
            cleanWs()
        } 
        failure {
            echo "Failed to Build LibraryOperations"
            cleanWs()
        }
    }
}