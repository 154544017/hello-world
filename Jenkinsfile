#!/usr/bin/env groovy
pipeline{
    agent any
    environment {
        // 使用 returnStdout
        RELEASE_VERSION = ""
    }
    stages{
        stage('First Step'){
            steps{
                script{
                    echo "${RELEASE_VERSION}"
                    sh 'echo $RELEASE_version'
                    var RELEASE_VERSION2 = generateImgVersion()
                    env.RELEASE_VERSION = RELEASE_VERSION2
                    echo "${env.RELEASE_VERSION}"
                    sh 'echo $RELEASE_version'
                }
                
            }
        }
        stage('Test'){
            steps{
                script{
                    echo "${RELEASE_VERSION}"
                    sh 'echo $RELEASE_version'
                }
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
    echo "${RELEASE_VERSION}"
    return RELEASE_VERSION
}