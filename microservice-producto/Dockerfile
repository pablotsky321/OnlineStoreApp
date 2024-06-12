FROM sapmachine:22-jdk-headless-ubuntu
COPY target/microservice-producto-0.0.1-SNAPSHOT.jar microservice-producto.jar
EXPOSE 8092
CMD ["java","-jar","microservice-producto.jar"]