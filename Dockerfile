FROM openjdk:17-oracle
ENV STUDENTS_INIT=true
WORKDIR /opt/app
ADD ./target/StudentsService-0.0.1-SNAPSHOT.jar ./app.jar
CMD ["java","-Djline.terminal=org.springframework.shell.core.IdeTerminal", "-jar", "/opt/app/app.jar"]