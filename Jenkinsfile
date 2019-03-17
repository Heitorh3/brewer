node {
 
    def mvnHome = tool name: 'maven_3.6.0', type: 'maven'
 
    stage ('SCM Checkout') {
        git 'https://github.com/Heitorh3/brewer'
    }
    
    stage ('Compile Stage') {
        sh "${mvnHome}/bin/mvn clean compile"
    }
 
    stage ('Testing Stage') {
        sh "${mvnHome}/bin/mvn test"       
    }
 
    stage ('Info Stage') {
        sh "${mvnHome}/bin/mvn info"       
    }

    
}
