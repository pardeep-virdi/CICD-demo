apt-get update
apt-get install openjdk-8-jdk -Y
export JAVA_HOME=/usr/lib/jvm/java/bin 
sh -c "echo export JAVA_HOME=/usr/lib/jvm/java/bin >> /etc/environment"
cd /tmp && wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
echo 'deb https://pkg.jenkins.io/debian-stable binary/' | sudo tee -a /etc/apt/sources.list.d/jenkins.list
apt update
 apt install jenkins
 systemctl status jenkins
 systemctl start jenkins
 cat /var/lib/jenkins/secrets/initialAdminPassword   
 # copy the password to dashboard
