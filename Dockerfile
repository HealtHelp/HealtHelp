FROM openjdk:8-alpine


COPY app /app

RUN cd HealtHelp-master/build/libs/healthelp-0.0.1-SNAPSHOT.jar

RUN ./gradlew build

RUN java -jar build/libs/gs-spring-boot-docker-0.1.0.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]