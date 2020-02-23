FROM openjdk:8-jdk-alpine
VOLUME /tmp
WORKDIR /usr/src/app/
COPY target/*.jar /usr/src/app/
RUN sh -c 'touch /usr/src/app/juteproduct-service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx200m", "-jar", "/usr/src/app/juteproduct-service.jar"]
EXPOSE 8101