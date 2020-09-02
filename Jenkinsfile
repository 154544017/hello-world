#!/usr/bin/env groovy
pipeline{
    agent any

    stages{
        stage('Build'){
            steps{
                dir('mock_svc'){
                    echo 'Building..'
                    pwd
                }
                
            }
        }
        stage('Test'){
            steps{
                echo 'Testing..'
            }
        }
        stage('Deploy'){
            steps{
                echo 'Deploying..'
            }
        }
    }
    
}