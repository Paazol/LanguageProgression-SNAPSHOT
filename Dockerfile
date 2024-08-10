FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY /target/LanguageProgression-0.0.1-SNAPSHOT.jar /app/progression.jar
ENTRYPOINT ["java", "-jar", "progression.jar"]
CMD java Main.java