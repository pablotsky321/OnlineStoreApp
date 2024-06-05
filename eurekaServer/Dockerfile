FROM sapmachine:22-jdk-headless-ubuntu
COPY target/eurekaServer-0.0.1-SNAPSHOT.jar eurekaServer.jar
ENTRYPOINT ["java","-jar","eurekaServer.jar"]