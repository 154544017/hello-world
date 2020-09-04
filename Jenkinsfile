#!/usr/bin/env groovy
pipeline{
    agent any
    environment {
    }
    stages{
        stage('First Step'){
            steps{
                script{
                    var RELEASE_VERSION2 = generateImgVersion()
                    echo "$RELEASE_VERSION2"
                    env.RELEASE_VERSION = RELEASE_VERSION2
                    echo "${env.RELEASE_VERSION}"
                }
                
            }
        }
        stage('Test'){
            steps{
                echo "${RELEASE_VERSION}"
            }
        }
        stage('Deploy'){
            steps{
                echo 'Deploying..'
            }
        }
    }
}

def generateImgVersion(){
    String semanticVersion = ''
    if(fileExists('pom.xml')) {
        semanticVersion =  "pomversion"
    }
    shortCommitID = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
    RELEASE_VERSION = "${semanticVersion}-${shortCommitID}-${env.BUILD_NUMBER}"
    echo "function ${RELEASE_VERSION}"
    return RELEASE_VERSION
}