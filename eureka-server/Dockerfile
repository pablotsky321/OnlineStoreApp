FROM sapmachine:22-jdk-headless-ubuntu
COPY target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
EXPOSE 8081
CMD ["java","-jar","eureka-server.jar"]