node {

stage('Clone sources') {
       // git branch: 'pipeline', url: 'https://github.com/pardeep-virdi/config-server.git'
     checkout([$class: 'GitSCM', branches: [[name: '*/pipeline']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/pardeep-virdi/config-server.git']]])
    }
    
      stage('SonarQube analysis') {
    // requires SonarQube Scanner 2.8+
    def scannerHome = tool 'LocalSonarScanner';
    withSonarQubeEnv('localsonar') {
      sh "${scannerHome}/bin/sonar-scanner  -Dsonar.projectKey=java-sonar-runner-simple   -Dsonar.sources=./src/ -Dproject.settings=sonar-project.properties"
    }
  }
       
stage('Maven build') {
        sh 'mvn clean  install' 
    }

stage('build docker image') {
    
    docker.withRegistry('', 'mydockerid') {
    
    def dockerfile = 'dockerfile'
    def customImage = docker.build("pardeepvirdi/config-server:${env.BUILD_ID}", "-f src/main/docker/${dockerfile} . ") 
    
    customImage.push()
     
    }
    
}
 
 stage('deploy on kubernetes') {    
   withKubeConfig([credentialsId: "mykube", serverUrl: "10.142.0.2:6443"]) {
        
           sh "kubectl -n default get nodes"

        }    
 }
   }
