FROM openjdk:11-oracle

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
COPY target/employee-1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

MAINTAINER AhmedSakr

#docker build -t workmotion/app .
#docker run -p 8080:8080 workmotion/app