FROM sapmachine:22-jdk-headless-ubuntu
RUN apt-get update && apt-get install -y curl
COPY target/config-server-0.0.1-SNAPSHOT.jar config-server.jar
EXPOSE 8888
CMD ["java","-jar","config-server.jar"]