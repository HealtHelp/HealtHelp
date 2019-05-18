FROM openjdk:8-jdk-alpine
ADD /build/libs/healthelp-0.0.1-SNAPSHOT.jar healthelp-0.0.1-SNAPSHOT.jar
EXPOSE 8088
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/healthelp-0.0.1-SNAPSHOT.jar"]