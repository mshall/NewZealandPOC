pipeline {
    agent any
    stages {
      
      stage('Spring-Config Java Build') {
        steps {
          notifyStarted("Spring-Config Java Build")
          echo "java build for Spring-Config"
          sh"""
            cd Spring-Config/ConfigServer
            mvn clean install package
            mvn clean deploy
          """        }
        post
        {
        success{
          notifySuccessful("Spring-Config Java Build")
          }
            failure{
              notifyFailed("Spring-Config Java Build")
               }
               
          }

      }
    
    stage('Spring-Config docker Build') {
      steps {
        notifyStarted("Spring-Config Docker Build")
        echo "docker build" 
        withCredentials([usernamePassword(credentialsId: '98a29d6f-4f30-485a-a758-475b5fe03274', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
          sh """
            cd Spring-Config/deployment/docker/
            rm -rf config
            cp -rf ${WORKSPACE}/Spring-Config/config .
            cp ${WORKSPACE}/Spring-Config/ConfigServer/target/ConfigServer-0.0.1-SNAPSHOT.jar .
            docker build --no-cache -t deploymentcoe.vodafone.skytapdns.com/nz-poc:v1 .
            docker login --username $USERNAME --password $PASSWORD https://deploymentcoe.vodafone.skytapdns.com
            docker push deploymentcoe.vodafone.skytapdns.com/nz-poc:v1
            #docker images
            docker rmi deploymentcoe.vodafone.skytapdns.com/nz-poc:v1
          """
        }
            
      }
      post
      {
      success{
        notifySuccessful("Spring-Config Docker Build")
        }
          failure{
            notifyFailed("Spring-Config Docker Build")
             }
        }  
    }

      stage('Spring-Config Deployment') {
        steps {
          
          echo "Deployment" 
          notifyStarted("Spring-Config Kubernetes Deployment")
          sh """
            cd Spring-Config/deployment
            kubectl delete -f manifests
            kubectl create -f manifests
            
           """
        }

        post
        {
          success{
            notifySuccessful("Spring-Config Kubernetes Deployment")
          }
          failure{
            notifyFailed("Spring-Config Kubernetes Deployment")
             }
        }
      
      }
    
    
    //Newzealand POC 
    stage('Newzealand POC Java Build') {
        steps {
          notifyStarted("Newzealand POC Java Build")
          echo "java build for Newzealand POC "
          sh"""
            cd NewZealandPOC
            mvn clean install package
            mvn clean deploy
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
    
    stage('NewZealandPOC docker Build') {
      steps {
        notifyStarted("NewZealandPOC Docker Build")
        echo "docker build" 
        withCredentials([usernamePassword(credentialsId: '98a29d6f-4f30-485a-a758-475b5fe03274', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
          sh """
            cd NewZealandPOC/deployment/docker/
            cp ${WORKSPACE}/NewZealandPOC/target/NewZealandPOC-0.0.1-SNAPSHOT.jar .
            docker build --no-cache -t deploymentcoe.vodafone.skytapdns.com/nz-poc-server-deploy:v1 .
            docker login --username $USERNAME --password $PASSWORD https://deploymentcoe.vodafone.skytapdns.com
            docker push deploymentcoe.vodafone.skytapdns.com/nz-poc-server-deploy:v1
            docker images
            docker rmi deploymentcoe.vodafone.skytapdns.com/nz-poc-server-deploy:v1
          """
        }

      }
      post
      {
      success{
        notifySuccessful("NewZealand POC Docker Build")
        }
          failure{
            notifyFailed("NewZealand POC Docker Build")
             }
        }  
    }
    
      stage('NewZealand POC Deployment') {
        steps {
          
          echo "Deployment" 
          notifyStarted("NewZealand POC Kubernetes Deployment")
          sh """
            cd NewZealandPOC/deployment
            #kubectl delete -f manifests
            kubectl create -f manifests
            
           """
        }

        post
        {
          success{
            notifySuccessful("NewZealand POC Kubernetes Deployment")
          }
          failure{
            notifyFailed("NewZealand POC Kubernetes Deployment")
             }
        }
      
      }

    }
}


//functions

def notifyStarted(stagename) {
  // send to Slack
  slackSend (color: '#FFFF00', message: "STARTED: Job $stagename '[${env.BUILD_NUMBER}]'", channel: 'nz-poc',token: 'JM1N6XtI0mj73fFIOfJppLAr')
}

def notifySuccessful(stagename) {
  // send to Slack
  slackSend (color: '#00FF00', message: "SUCCESSFUL: Job $stagename '[${env.BUILD_NUMBER}]'", channel: 'nz-poc',token: 'JM1N6XtI0mj73fFIOfJppLAr')
 
 }

def notifyFailed(stagename) {
  // send to Slack
  slackSend (color: '#FF0000', message: "FAILED: Job $stagename' [${env.BUILD_NUMBER}]'", channel: 'nz-poc',token: 'JM1N6XtI0mj73fFIOfJppLAr')
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

