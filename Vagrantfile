# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  config.vm.box = "ubuntu/trusty64"

  config.vm.network :forwarded_port, guest: 80, host: 8000

  config.vm.provider "virtualbox" do |vb|
     vb.name = "NHS QS Portal"
     vb.memory = "1024"
  end

  config.vm.provision "shell", inline: <<PROVISIONSCRIPT
    sudo debconf-set-selections <<< 'mysql-server-5.5 mysql-server/root_password password rootpass'
    sudo debconf-set-selections <<< 'mysql-server-5.5 mysql-server/root_password_again password rootpass'
    sudo apt-get update
    sudo apt-get -y install mysql-server-5.5
    apt-add-repository ppa:webupd8team/java
    apt-get update
    echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
    apt-get -y install oracle-java8-installer
    update-java-alternatives -s java-8-oracle
    wget -q http://www.mirrorservice.org/sites/ftp.apache.org/maven/maven-3/3.3.1/binaries/apache-maven-3.3.1-bin.tar.gz -O /tmp/apache-maven-3.3.1-bin.tar.gz
    cd /tmp
    tar xvzf apache-maven-3.3.1-bin.tar.gz
    mv apache-maven-3.3.1 /var/local/
    sudo ln -s /var/local/apache-maven-3.3.1/bin/mvnyjp /usr/local/bin/mvnyjp
    sudo ln -s /var/local/apache-maven-3.3.1/bin/mvnDebug /usr/local/bin/mvnDebug
    sudo ln -s /var/local/apache-maven-3.3.1/bin/mvn /usr/local/bin/mvn
    apt-get autoremove -y
PROVISIONSCRIPT

end