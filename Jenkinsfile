pipeline {
    agent any
    tools { 
            maven 'Maven 3.3.9' 
            jdk 'jdk8' 
        }
        
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven_3.6.0') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3.6.0') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
                withMaven(maven : 'maven_3.6.0') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}
