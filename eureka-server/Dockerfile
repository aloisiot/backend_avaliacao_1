FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=/target/eureka-server-0.0.1-SNAPSHOT.jar
ARG APP_NAME=eureka-server.jar
COPY ${JAR_FILE} ${APP_NAME}
EXPOSE 8761
ENTRYPOINT [ "java", "-jar" , "eureka-server.jar"]
