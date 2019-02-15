#!/bin/bash
yum update -y
wget https://s3-us-west-2.amazonaws.com/kk-uploads-oregon/spring-cloud-aws-microservice-product.war
mv *.war app.war
java -jar app.war --server.port=80
