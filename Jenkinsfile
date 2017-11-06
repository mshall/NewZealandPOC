pipeline {
    agent any
    stages {
      
      stage('Java Build') {
        steps {
          notifyStarted("Java Build")
          echo "java build for Spring-Config"
          sh"""
            cd Spring-Config/spring-cloud-config-server
            mvn clean install package
            mvn deploy
          """
        }
        post
        {
        success{
          notifySuccessful("Java Build")
          }
            failure{
              notifyFailed("Java Build")
               }
          }

      }
    /* 
    stage('docker Build') {
      steps {
        notifyStarted("Docker Build")
        echo "docker build" 
        withCredentials([usernamePassword(credentialsId: '98a29d6f-4f30-485a-a758-475b5fe03274', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
          sh """
            cd deploy/docker/
            cp ${WORKSPACE}/target/account-1.0-SNAPSHOT.war .
            cp /tmp/jetty-runner-9.4.7.v20170914.jar .
            docker build -t deploymentcoe.vodafone.skytapdns.com/cicd-demo2 .
            docker login --username $USERNAME --password $PASSWORD https://deploymentcoe.vodafone.skytapdns.com
            docker push deploymentcoe.vodafone.skytapdns.com/cicd-demo2
            docker images
            docker rmi deploymentcoe.vodafone.skytapdns.com/cicd-demo2
          """
        }
            
      }
      post
      {
      success{
        notifySuccessful("Docker Build")
        }
          failure{
            notifyFailed("Docker Build")
             }
        }  
    }

      stage('Deployment') {
        steps {
          
          echo "Deployment" 
          notifyStarted("Kubernetes Deployment")
          sh """
            
            kubectl delete -f deploy/manifests
            kubectl create -f deploy/manifests
            
           """  
        }

        post
        {
          success{
            notifySuccessful("Kubernetes Deployment")
          }
          failure{
            notifyFailed("Kubernetes Deployment")
             }
        }
      
      }
      */
    }


}


//functions

def notifyStarted(stagename) {
  // send to Slack
  slackSend (color: '#FFFF00', message: "STARTED: Job $stagename '[${env.BUILD_NUMBER}]'", channel: 'nz-demo')
}

def notifySuccessful(stagename) {
  // send to Slack
  slackSend (color: '#00FF00', message: "SUCCESSFUL: Job $stagename '[${env.BUILD_NUMBER}]'", channel: 'nz-demo')
 
 }

def notifyFailed(stagename) {
  // send to Slack
  slackSend (color: '#FF0000', message: "FAILED: Job $stagename' [${env.BUILD_NUMBER}]'", channel: 'nz-demo')
/*
 // send mail
  emailext attachLog: true, subject: "Jenkins Job ${env.JOB_NAME} $stagename [${env.BUILD_NUMBER}] failed", to: 'yara.abdellatif1@vodafone.com,manar.hassan1@vodafone.com,ahmed.said-abdallah2@vodafone.com', body: """
Dears,
Kindly be informed that the job $stagename has failed, please find the logs attached to this email.
      
Thanks
Deployment CoE
"""
*/
}

