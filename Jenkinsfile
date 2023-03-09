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
         
        stage ('Testing Stage') {
            steps {
                sh "mvn test"       
            }
        }
        
        stage ('Compile Stage') {
            steps {
                sh "mvn test-compile"       
            } 
        }
               
        stage ('Building Stage') {
            steps {
                sh "mvn install"       
            }
        }
        
        stage('Example Deploy') {
            when {
                branch 'master'
                    environment name: 'DEPLOY_TO', value: 'master'
                }
            }
        stage ('Migration database Stage') {

            steps {
               sh "mvn -Dflyway.user=brewer -Dflyway.password=Yw2Y4VC5drrwdMZj -Dflyway.url=jdbc:mysql://localhost/brewer?useSSL=false flyway:migrate" 
            }
        }
       production
         stage('Example Production') {
            when {
                beforeInput true
                branch 'production'
            }
            input {
                message "Deploy to production?"
                id "simple-input"
            }
            steps {
                echo 'Production'
            }
        }
        stage ('Package Stage') {
            steps {
                sh "mvn package"       

        stage('Push artifact') {
            steps {               
                 sh "cp target/*.war /opt/tomcat8/webapps/"
                 sh "/opt/tomcat8/bin/startup.sh"
                }
            
            }
        stage('Publish report') {
            steps {  
                  publishHTML(target: [reportDir: 'target', reportFiles: 'index.html', reportName: 'Testes Instrumentados'])
            }
        }
        /*
        
         step([$class: 'CopyArtifact', 
                        filter: 'target/brewer-1.0.0-SNAPSHOT.war', 
                        fingerprintArtifacts: true, 
                        allowEmptyArchive: true,
                        projectName: '${JOB_NAME}', 
                        selector: lastSuccessful()
                      ])
        
         stage('Pull artifact') {
            steps {
                step([  $class: 'CopyArtifact',
                        filter: '*.war',
                        fingerprintArtifacts: true,
                        projectName: '${JOB_NAME}',
                        selector: [$class: 'SpecificBuildSelector', buildNumber: '${BUILD_NUMBER}']
                ])
                //unzip zipFile: 'test.zip', dir: './archive_new'
                //sh 'cat archive_new/test.txt'
            }
        }*/
    }
}
