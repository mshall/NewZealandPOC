FROM openjdk:8u111-jdk-alpine

EXPOSE 8080
VOLUME /tmp
RUN mkdir /spring-cloud-config-server
ADD spring-cloud-config-server-0.0.1-SNAPSHOT.jar /spring-cloud-config-server/spring-cloud-config-server.jar
ADD logging.properties logging.properties
ADD config config
RUN sh -c 'touch /spring-cloud-config-server/spring-cloud-config-server.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx512M","-jar","/spring-cloud-config-server/spring-cloud-config-server.jar"]
