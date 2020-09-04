pipeline {
    agent any

    environment {
        FOO = "initial FOO env value"
    }

    stages {
        stage("Stage 1") {
            steps {
                script {
                    echo "FOO is '${FOO}'" // prints: FOO is 'initial FOO env value'

                    env.BAR = test()
                }
                container('docker'){
                    sh "docker ps"
                }
            }
        }

        stage("Stage 2") {
            steps {
                echo "env.BAR is '${BAR}'" // prints: env.BAR is 'bar'
                echo "FOO is '${FOO}'" // prints: FOO is 'initial FOO env value'
                echo "env.FOO is '${env.FOO}'" // prints: env.FOO is 'initial FOO env value'
                script {
                    FOO = "test2"
                    env.BAR = "bar2"
                }
            }
        }

        stage("Stage 3") {
            steps {
                echo "FOO is '${FOO}'" // prints: FOO is 'test2'
                echo "env.FOO is '${env.FOO}'" // prints: env.FOO is 'initial FOO env value'
                echo "env.BAR is '${BAR}'" // prints: env.BAR is 'bar2'

                script {
                    FOO = "test3"
                }

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