FROM sapmachine:22-jdk-headless-ubuntu
COPY target/configServer-0.0.1-SNAPSHOT.jar configServer.jar
ENTRYPOINT ["java","-jar","configServer.jar"]