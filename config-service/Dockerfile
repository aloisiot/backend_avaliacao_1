FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=/target/config-service-0.0.1-SNAPSHOT.jar
ARG APP_NAME=config-service.jar
COPY ${JAR_FILE} ${APP_NAME}
EXPOSE 8761
ENTRYPOINT [ "java", "-jar" , "config-service.jar"]
