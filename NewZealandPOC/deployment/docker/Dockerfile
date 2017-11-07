FROM openjdk:8u111-jdk-alpine
HEALTHCHECK --interval=5s --timeout=10s --retries=2 CMD if [ `curl -w "%{http_code}\n"  -o /dev/null -iL -s http://127.0.0.1:8080/health` -ne 200 ] ; then exit 1 ;fi
RUN apk add --update curl && rm -rf /var/cache/apk/*
CMD ["/bin/sh"]
VOLUME /tmp
EXPOSE 8080
ADD NewZealandPOC-0.0.1-SNAPSHOT.jar /NewZealandPOC-0.0.1-SNAPSHOT.jar
RUN sh -c 'touch /NewZealandPOC-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx512M","-jar","/NewZealandPOC-0.0.1-SNAPSHOT.jar"]

