pipeline {
    agent any

    stages {
        stage('Creating MySql Container') {
            steps {
                //Pulling latest mysql version.
                sh "docker pull mysql:latest"
                //Creating container name on local istance with name of mysql_container and database_name.
                sh "docker container create -p 3306:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=library mysql"
            }
        }

        stage("Creating a connection reference database") {
            steps {
                //Create a connection between database and database, than connect it.
                sh "docker network ls"
                sh "docker network create libraryconnect"
                sh "docker network connect libraryconnect mysqldb"
            }
        }
    }

    post {
        success {
            echo "MySQL Image created successfully"
        }
        
        failure {
            echo "Oops! Something wrong with pipeline code"
        }
    }
}
