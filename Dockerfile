FROM java:8-alpine

ADD ./stu-bootstrap/target/stu-bootstrap-0.0.1-SNAPSHOT.jar bootstrap.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.config.name=application-remote", "-jar", "bootstrap.jar"]