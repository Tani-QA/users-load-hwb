FROM openjdk:17-jdk-alpine
RUN apk update && apk add --no-cache git maven
WORKDIR /projects/users
RUN git clone https://github.com/Tani-QA/users-load-hwb.git
WORKDIR /projects/users/users-load-hwb/Users/_scripts_java/users
RUN mvn clean package install
CMD ["java", "-jar", "target/users-0.0.1-SNAPSHOT.jar", "--server.port=8080"]

WORKDIR /projects/users/users-load-hwb/Users/_scripts_java
ENTRYPOINT ["java", "-jar", "users/jolokia-jvm-1.7.2.jar", "--port=8778", "start"]