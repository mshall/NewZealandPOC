FROM openjdk:8u111-jdk-alpine
HEALTHCHECK --interval=5s --timeout=10s --retries=2 CMD if [ `curl -w "%{http_code}\n"  -o /dev/null -iL -s http://127.0.0.1:8080/health` -ne 200 ] ; then exit 1 ;fi
RUN apk add --update curl && rm -rf /var/cache/apk/*
CMD ["/bin/sh"]
VOLUME /tmp
RUN mkdir ConfigServer
ADD ConfigServer-0.0.1-SNAPSHOT.jar /ConfigServer/ConfigServer-0.0.1-SNAPSHOT.jar
ADD config config
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx512M","-jar","ConfigServer/ConfigServer-0.0.1-SNAPSHOT.jar"]
