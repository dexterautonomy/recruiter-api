FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/user-api-v1.jar

WORKDIR /opt/app

COPY ${JAR_FILE} user-api.jar

ENTRYPOINT ["java","-jar","user-api.jar"]