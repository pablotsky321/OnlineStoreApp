FROM sapmachine:22-jdk-headless-ubuntu
COPY target/microservice-user-0.0.1-SNAPSHOT.jar microservice-user.jar
ENTRYPOINT ["java","-jar","microservice-user.jar"]