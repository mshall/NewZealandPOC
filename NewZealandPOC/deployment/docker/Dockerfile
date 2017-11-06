FROM openjdk:8u111-jdk-alpine
HEALTHCHECK --interval=5s --timeout=10s --retries=2 CMD if [ `curl -w "%{http_code}\n"  -o /dev/null -iL -s http://127.0.0.1:8080/health` -ne 200 ] ; then exit 1 ;fi
RUN apk add --update curl && rm -rf /var/cache/apk/*
RUN adduser -D demo
RUN chown demo:root -R /usr/lib/jvm/java-1.8-openjdk/ 
WORKDIR /home/demo
EXPOSE 8080
USER demo
VOLUME /tmp
ADD NewZealandPOC-0.0.1-SNAPSHOT.jar NewZealandPOC-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx512M","-jar","NewZealandPOC-0.0.1-SNAPSHOT.jar "]