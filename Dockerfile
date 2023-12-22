FROM openjdk:17

RUN mkdir -p /project
WORKDIR /project
COPY ./build/libs/*.jar /project/app.jar
CMD ["java", "-jar", "/project/app.jar"]