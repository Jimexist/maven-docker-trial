FROM maven:3.3-jdk-8-onbuild

EXPOSE 8080 8081

CMD ["java", "-jar", "target/maven-docker-fun-1.0-SNAPSHOT.jar", "server", "./configs/hello-world.yml"]
