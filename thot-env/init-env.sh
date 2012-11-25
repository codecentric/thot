#!/bin/bash

# download tomcat from web 

TOMCAT_VERSION=7.0.33
PACKAGE_URL=http://ftp-stud.hs-esslingen.de/pub/Mirrors/ftp.apache.org/dist/tomcat/tomcat-7/v$TOMCAT_VERSION/bin/apache-tomcat-$TOMCAT_VERSION.tar.gz


if [ ! -d download ]
then
  mkdir download
fi

if [ ! -d target ]
then
  mkdir target
fi

if [ ! -e download/apache-tomcat-$TOMCAT_VERSION.tar.gz ]
then
  pushd download
  wget $PACKAGE_URL
  popd
fi

if [ ! -d target/apache-tomcat-$TOMCAT_VERSION.tar.gz ]
then
  tar -C target -xzf download/apache-tomcat-$TOMCAT_VERSION.tar.gz
fi

cp files/tomcat-users.xml target/apache-tomcat-$TOMCAT_VERSION/conf/tomcat-users.xml
