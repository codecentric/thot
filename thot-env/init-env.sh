#!/bin/bash

PACKAGE_URL=http://apache.mirror.iphh.net/tomcat/tomcat-7/v7.0.29/bin/apache-tomcat-7.0.29.tar.gz

if [ ! -d download ]
then
  mkdir download
fi

if [ ! -d target ]
then
  mkdir target
fi

if [ ! -e download/apache-tomcat-7.0.29.tar.gz ]
then
  pushd download
  wget $PACKAGE_URL
  popd
fi

if [ ! -d target/apache-tomcat-7.0.29 ]
then
  tar -C target -xzf download/apache-tomcat-7.0.29.tar.gz
fi

cp files/tomcat-users.xml target/apache-tomcat-7.0.29/conf/tomcat-users.xml
