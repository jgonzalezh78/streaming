FROM adoptopenjdk/openjdk11:latest
RUN mkdir /opt/app
COPY /target/listener-0.0.1-SNAPSHOT.jar /opt/app/java-app.jar
CMD ["java", "-jar", "/opt/app/java-app.jar"]