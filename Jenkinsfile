#!/usr/bin/env groovy
pipeline{
    agent any
    environment {
        RELEASE_VERSION = ""
    }
    stages{
        stage('First Step'){
            steps{
                echo "${env.RELEASE_VERSION}"
                generateImgVersion()
                echo "${env.RELEASE_VERSION}"
                
            }
        }
        stage('Test'){
            steps{
                echo "${env.RELEASE_VERSION}"
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
}