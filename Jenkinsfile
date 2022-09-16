pipeline {
    agent any
trigers{cron{'* * * * *'}}
    stages {

        stage('Run') {
            steps {
                 bat "mvn test"//sh Linux
            }
        }
    }
    post {
            always {
              step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
            }
          }
}