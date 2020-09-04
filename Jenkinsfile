pipeline {
    agent any

    environment {
        FOO = "initial FOO env value"
    }

    stages {
        stage("Stage 1") {
            steps {
                container('docker') {
                    sh "docker ps"
                }
            }
        }

        stage("Stage 2") {
            steps {

                echo "FOO is '${FOO}'" // prints: FOO is 'initial FOO env value'

            }
        }

        stage("Stage 3") {
            steps {


                echo "FOO is '${FOO}'" // prints: FOO is 'test3'
            }
        }
    }
}

def test(){
        String semanticVersion = ''
        if(fileExists('build.gradle')) {
            semanticVersion =  "version"
        }
        shortCommitID = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
        RELEASE_VERSION = "${semanticVersion}-${shortCommitID}-${env.BUILD_NUMBER}"
        return RELEASE_VERSION
}