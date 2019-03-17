pipeline {
    agent any
    
    tools {
        maven 'maven_3.6.0'
    }
    
    //def mvnHome = tool name: 'maven_3.6.0', type: 'maven'
    stages {
        stage ('SCM Checkout') {
            git 'https://github.com/Heitorh3/brewer'
        }
        stage ('Compile Stage') {
            sh "mvn clean compile"
        }
    }
}
