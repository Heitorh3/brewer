pipeline {
    agent any
    
    tools {
        maven 'maven_3.6.0'
    }
    
    //def mvnHome = tool name: 'maven_3.6.0', type: 'maven'
    stages {
        stage ('SCM Checkout') {
            steps {
                git 'https://github.com/Heitorh3/brewer'
            }   
        }
        stage ('Compile Stage') {
            steps {
                sh "mvn clean compile"
            }
        }
        
        stage ('Testing and Compile Stage') {
            steps {
                sh "mvn test-compile"       
            }
        }
    }
}
