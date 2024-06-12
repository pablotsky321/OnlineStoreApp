FROM sapmachine:22-jdk-headless-ubuntu
COPY target/microservice-ordenes-0.0.1-SNAPSHOT.jar microservice-ordenes.jar
EXPOSE 8091
CMD ["java","-jar","microservice-ordenes.jar"]