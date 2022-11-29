pipeline {
    agent any

    tools {
        maven "Maven 3.8.6"
    }

    stages {
        stage('Build') {
            steps {
                script {
                    dir("dress-product-example/microservicetwo-example") {
                        sh "mvn -v"
                        sh "mvn -Dmaven.test.failure.ignore=true clean package"
                    }
                }
            }
        }
        stage ('Create Container') {
            steps {
                script {
                    dir("dress-product-example/microservicetwo-example") {
                        sh "docker build -t dressproducttwo ."
                        sh "docker container create --name MicroserviceB -p 8082:8082 dressproducttwo"
                    }
                }
            }
        }
        stage ('Echo Messages') {
            steps {
                script {
                    echo "DressProductTwo Container Successful"
                    echo "Test OK With Pipeline"
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
