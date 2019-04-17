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
        
        stage ('Testing Stage') {
            steps {
                sh "mvn test"       
            }
        }
        
        stage ('Testing and Compile Stage') {
            steps {
                sh "mvn test-compile"       
            }
        }
       
        stage('Example') {
            input {
                message "Should we continue?"
                ok "Yes, we should."
                //submitter "alice,bob"
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
                }
            }
            steps {
                echo "Hello, ${PERSON}, nice to meet you."
            }
        }
        
        stage('Example Deploy') {
            when {
                branch 'master'
            }
            steps {
                echo 'Deploying'
            }
        }
        
        stage ('Package Stage') {
            steps {
                sh "mvn package"       
            }
        }
        
        stage ('Install Stage') {
            steps {
                sh "mvn install"       
            }
        }
        
        stage ('Build artfact Stage') {
            steps {
                archive 'target/*.war'      
            }
        }
        
        stage('Copy archive') {
            steps {
                echo '${JOB_NAME}'
                copyArtifacts filter: 'target/brewer-1.0.0-SNAPSHOT.war', 
                    fingerprintArtifacts: true, 
                    projectName: '${JOB_NAME}', 
                    selector: specific('${BUILD_NUMBER}')
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
