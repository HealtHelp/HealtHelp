FROM centos
RUN yum install -y java
VOLUME /tmp
ADD /build/libs/healthelp-0.0.1-SNAPSHOT.jar healthelp-0.0.1-SNAPSHOT.jar
EXPOSE 8088
RUN sh -c 'touch /healthelp-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/healthelp-0.0.1-SNAPSHOT.jar"]