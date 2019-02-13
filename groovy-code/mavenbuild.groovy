node {

stage('Clone sources') {
       // git branch: 'pipeline', url: 'https://github.com/pardeep-virdi/config-server.git'
     checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/pardeep-virdi/maven.git']]])
    }
    
    
stage('Maven build') {
        sh 'mvn clean  install' 
    }

//stage('build docker image') {
    
//    docker.withRegistry('', 'mydockerid') {
    
 //   def dockerfile = 'dockerfile'
  //  def customImage = docker.build("pardeepvirdi/maven-project:${env.BUILD_ID}", "-f src/main/docker/${dockerfile} . ") 
    
   // customImage.push()
     
   // }
    
//}
    
   }
