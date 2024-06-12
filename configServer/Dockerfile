FROM sapmachine:22-jdk-headless-ubuntu
COPY target/configServer-0.0.1-SNAPSHOT.jar config-server.jar
EXPOSE 8888
CMD ["java","-jar","config-server.jar"]