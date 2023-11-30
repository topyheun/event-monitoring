FROM openjdk:17

RUN mkdir -p /monitoring
WORKDIR /monitoring
COPY ./build/libs/*.jar /monitoring/app.jar
CMD ["java", "-jar", "/monitoring/app.jar"]