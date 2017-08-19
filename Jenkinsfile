pipeline {
//Pipeline

agent any
triggers { cron('*/2 * * * *') }
//parameters {
//        choice(
//            choices: 'staging\nprakashul-qa',
//            description: '',
//            name: 'REQUESTED_ACTION')
//}


    stages {

        stage ('Workspace Cleanup') {
          steps {
              deleteDir()
    	         }
                                    }

    	stage ('SCM Checkout') {
		steps {
			script {
			try {
				timeout(time: 20, unit: 'SECONDS') {

			checkout([$class: 'GitSCM', branches: [[name: '*/prakashul-qa']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'e33a422c-b11f-4a16-8637-4037f9ddaf66', url: 'https://github.com/nitinbhadauria/KSS-Jenkins.git']]])
  	   		}

			}

			catch(err) {
                err.printStackTrace()
                                                }
                sh 'echo Proceeding'
               }
            }
                          }

	stage("build_artifact") {
        agent { docker "maven:3-jdk-8" }
//	when {
  //              expression { params.REQUESTED_ACTION == 'prakashul-qa' }
    //        }
            steps {
                sh 'mvn package'
                sh 'ls -R *'

                  }
                }

    stage("build_push_image") {

      agent any

//	when {
  //              expression { params.REQUESTED_ACTION == 'prakashul-qa' }
    //        }


        steps {
              withDockerRegistry([credentialsId: 'b6ef8f34-268d-4a12-a02f-c0eb8bf002ec', url: "https://hub.docker.com/"]) {

                script {
        // we give the image the same version as the .war package
              def image = docker.build("prakashul/knowledgemeet:latest",'.')
              image.push()

        try {
        timeout(time: 20, unit: 'SECONDS') {
        input 'Do you want to proceed to the Deployment?'
        }
  }
        catch(err) {
                err.printStackTrace()
                                                }
                sh 'echo Proceeding To Deployment'
               }

}
}
}

    stage("deploy") {
      agent any
      steps {
        sh '. /var/lib/jenkins/deploy.sh'
      }

    }

            }



    post {
        always {
            archive "target/**/*.jar"
            // junit 'target/surefire-reports/*.xml'
        }
    }
}
