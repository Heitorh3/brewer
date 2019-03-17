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
                submitter "alice,bob"
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
                }
            }
            steps {
                echo "Hello, ${PERSON}, nice to meet you."
            }
        }
        stage('Copy artifact') {
            steps {
                copyArtifacts 
                    filter: '*.war', 
                    fingerprintArtifacts: true, 
                    projectName: 'Brewer Pipeline', 
                    selector: lastSuccessful(), 
                    target: 'deploy'
            }
        }
      /*   stage('Pull artifact') {
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
