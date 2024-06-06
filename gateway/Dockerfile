FROM sapmachine:22-jdk-headless-ubuntu
COPY target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
ENTRYPOINT ["java","-jar","gateway.jar"]