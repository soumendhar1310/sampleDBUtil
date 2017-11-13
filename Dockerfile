FROM java:8
VOLUME /tmp
ADD target/sampleDUtil-0.0.1-SNAPSHOT.jar sampleDBservice.jar
RUN bash -c 'touch /sampleDBservice.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /sampleDBservice.jar --spring.config.location=/deployments/config/application.properties"]