pipeline {
    agent any

    tools {
        maven "Maven 3.8.6"
    }

    stages {
        stage('Build') {
            steps {
                script {
                    dir("dress-product-example/microserviceone-example") {
                        sh "mvn -v"
                        sh "mvn -Dmaven.test.failure.ignore=true clean package"
                    }
                }
            }
        }
        stage ('Create Container') {
            steps {
                script {
                    dir("dress-product-example/microserviceone-example") {
                        sh "docker build -t dressproductone ."
                        sh "docker container create --name MicroserviceA -p 8081:8081 dressproductone"
                    }
                }
            }
        }
        stage ('Echo Messages') {
            steps {
                script {
                    echo "DressProductOne Container Successful"
                    echo "Test OK With Pipeline"
                }
            }
        }
        stage ('Post Deleting') {
            steps {
                script {
                    sh "docker container rm MicroserviceA"
                    sh "docker image rm dressproductone"
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo "All Building Successfully"
        }
        failure {
            echo "Something wrong with Pipeline"
        }
    }
}
