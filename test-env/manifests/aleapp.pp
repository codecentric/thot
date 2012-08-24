class mysql {

  package { "mysql-server":
    ensure => installed,
  }

}

class oracle_jdk7 {

  exec { "unpack-jdk": 
    command => "/bin/tar -C /opt/ -xzf /vagrant/files/jdk-7u4-linux-x64.tar.gz",
  } ->

  exec { [ 
      "/usr/sbin/update-alternatives --install '/usr/bin/java' 'java' '/opt/jdk1.7.0_04/bin/java' 1",
      "/usr/sbin/update-alternatives --install '/usr/bin/javac' 'javac' '/opt/jdk1.7.0_04/bin/javac' 1",
      "/usr/sbin/update-alternatives --install '/usr/bin/javaws' 'javaws' '/opt/jdk1.7.0_04/bin/javaws' 1"  ] :
  }

}

class tomcat7 {

  exec { "unpack-tomcat":
    command => "/bin/tar -C /opt/ -xzf /vagrant/files/apache-tomcat-7.0.29.tar.gz",
  } ->

  file { "/opt/apache-tomcat-7.0.29/conf/tomcat-users.xml":
    source => "/vagrant/files/tomcat-users.xml",
  } ->

  exec { "start-tomcat":
    command => "/opt/apache-tomcat-7.0.29/bin/startup.sh",
  }

}

include mysql
include oracle_jdk7
include tomcat7

