yum install java-1.8.0-openjdk-devel
 /usr/lib/jvm/java/bin/java -version
 export JAVA_HOME=/usr/lib/jvm/java/bin
 sudo sh -c "echo export JAVA_HOME=/usr/lib/jvm/java/bin >> /etc/environment"
 wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
  rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key
   yum install jenkins -Y
   systemctl start jenkins
   cat /var/lib/jenkins/secrets/initialAdminPassword
   yum install git -Y
