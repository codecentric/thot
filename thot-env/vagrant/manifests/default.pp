# Basic Puppet Apache manifest

class thot {

  $user_name = "david"
  $user_home = "/home/${user_name}"
  $download_dir = "${user_home}/Downloads"
  $checkout_dir = "${user_home}/thot"
  $project_dir = "${checkout_dir}/thot-app"
  $workspace_dir = "${user_home}/Documents/workspace-sts-3.1.0.RELEASE"
  
  user { $user_name:
	ensure     => present,
	gid        => $user_name,
	shell      => '/bin/sh',
	home       => $user_home,
	managehome => true,
  }
  
  exec { "apt-get update":
    command => "/usr/bin/apt-get update"
  }

  package { "mysql-server":
    ensure => present, 
  }
  
  service { "mysql":
    ensure => running,
    require => Package["mysql-server"],
  }

  package { "rpm":
    ensure => present,
  }

  package { "git-core":
    ensure => present,
  }
  
  package { "maven2":
    ensure => present,
  }
  
  package { "openjdk-7-jdk":
    ensure => present,
  }
  
  #$jdk_file = "jdk-6-linux-i586-rpm.bin"
  #$download_url = "http://download.oracle.com/otn-pub/java/jdk/6/${jdk_file}"
  #$jdk_file = "jdk-6u38-linux-i586-rpm.bin"
  #$download_url = "http://download.oracle.com/otn-pub/java/jdk/6u38-b05/${jdk_file}"
  $jdk_file = "jdk-7u9-linux-i586.tar.gz"
  $download_url = "http://download.oracle.com/otn-pub/java/jdk/7u9-b05/${jdk_file}"
  $jdk_file_absolute = "${download_dir}/${jdk_file}"
  #exec { "download oracle jdk": 
  #	command => "/usr/bin/wget -O ${jdk_file_absolute} --no-cookies --header \"Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com\" \"${download_url}\"",
  #  creates => $jdk_file_absolute,
  #	timeout => 0,
  #}
  
  $sts_version = "3.4.0"
  $eclipse_version = "3.8.2"
  $platform_suffix = "-x86_64"
  $sts_file = "spring-tool-suite-${sts_version}.RELEASE-e${eclipse_version}-linux-gtk${platform_suffix}.tar.gz"
  $sts_file_absolute = "${download_dir}/${sts_file}"
  $sts_download_url = "http://download.springsource.com/release/STS/${sts_version}/dist/e${eclipse_version}/${sts_file}"
  exec { "download STS": 
	command => "/usr/bin/wget -O ${sts_file_absolute} \"${sts_download_url}\"",
    creates => $sts_file_absolute,
	timeout => 0,
  }
  
  $tomcat_version = "7.0.42"
  $apache_mirror = "http://mirror.softaculous.com/apache"
  $tomcat_name_with_version = "apache-tomcat-${tomcat_version}"
  $tomcat_file = "${tomcat_name_with_version}.tar.gz"
  $tomcat_absolute_file = "${download_dir}/${tomcat_file}"
  $tomcat_download_url = "${apache_mirror}/tomcat/tomcat-7/v${tomcat_version}/bin/${tomcat_file}"
  exec { "download tomcat": 
	command => "/usr/bin/wget -O ${tomcat_absolute_file} \"${tomcat_download_url}\"",
	unless => "/usr/bin/test -f ${tomcat_absolute_file} /usr/bin/test -s ${tomcat_absolute_file}",
    creates => $tomcat_absolute_file,
	timeout => 0,
  }

  $software_base_dir = "/usr/local"  
  
  $catalina_home = "${software_base_dir}/${tomcat_name_with_version}"
  exec { "install tomcat": 
	command => "/bin/tar xzf ${tomcat_absolute_file} -C ${software_base_dir}",
	creates => $catalina_home,
	require => Exec["download tomcat"],
  }

  $sts_home = "${software_base_dir}/springsource"
  exec { "install STS": 
	command => "/bin/tar xzf ${sts_file_absolute} -C ${software_base_dir}",
	creates => $sts_home,
	require => Exec["download STS"],
  }
  
  #exec { "install jdk": 
#	command => "/usr/bin/rpm -i ${jdk_file_absolute}",
	#require => [Package["rpm"], Exec["download oracle jdk"]],
  #}
  
  $repo = "https://github.com/codecentric/thot.git"
  exec { "checkout": 
	command => "/usr/bin/git clone ${repo} ${checkout_dir}",
	creates => $checkout_dir,
	timeout => 0,
  }
  
  exec { "chowner to user": 
	command => "/bin/chown -R ${user_name}:${user_name} ${catalina_home} ${sts_home} ${checkout_dir}",
	require => [Exec["install STS"], Exec["install tomcat"], Exec["checkout"]],
  }
  
  exec { "mvn eclipse:eclipse thot-app": 
    cwd => $project_dir,
	creates => "${project_dir}/.project",
	command => "sudo -u ${user_name} mvn eclipse:clean eclipse:eclipse eclipse:add-maven-repo -Declipse.workspace=${workspace_dir}",
	path => "/usr/bin",
	require => Exec["chowner to user"],
	timeout => 0,
  }
  
  exec { "create db":
    command => "/usr/bin/mysql -u root < ${project_dir}/src/main/resources/sql/init-db.sql",
    unless => "/usr/bin/mysql -u root -e 'use thot'",
	require => [Package["mysql-server"], Exec["checkout"]],
  }

  exec { "import test data into db":
    command => "/usr/bin/mysql -u thot < ${project_dir}/src/main/resources/sessions.sql",
    unless => "/usr/bin/mysql -u root -e 'use thot'",
    require => Exec["create db"],
  }
    
  package { "firefox":
    ensure => present,
  }

  $acceptance_test_project_dir = "${checkout_dir}/thot-acceptanceTests"
  exec { "mvn eclipse:eclipse thot-acceptanceTests": 
    cwd => $acceptance_test_project_dir,
	creates => "${acceptance_test_project_dir}/.project",
	command => "/usr/bin/sudo -u ${user_name} mvn eclipse:clean eclipse:eclipse",
	require => [Exec["chowner to user"], Package["firefox"]],
	timeout => 0,
  }

}

include thot
