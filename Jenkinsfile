pipeline {
 agent any
 
 tools {  
       def mvnHome = tool name: 'maven_3.6.0', type: 'maven'
    }
 
 stages {

    stage ('SCM Checkout') {
     steps {
        git 'https://github.com/Heitorh3/brewer'
      }
    }

    stage ('Testing Stage') {
     steps {
        sh "${mvnHome}/bin/mvn test"       
      }
    }

    stage ('Compile Stage') {
     steps {
        sh "${mvnHome}/bin/mvn package"
      }
    }
  }
}
