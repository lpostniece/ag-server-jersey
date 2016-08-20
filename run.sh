#!/bin/bash
sbt package
cp target/scala-2.11/ag-server_2.11-1.0.war ag-server.war
cp ag-server.war /usr/local/Cellar/tomcat/8.0.35/libexec/webapps/
catalina stop -force
catalina start
