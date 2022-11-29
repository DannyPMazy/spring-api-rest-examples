FROM maven:3.8-jdk-11
EXPOSE 8082
ADD /target/libraryloan.jar libraryloan.jar
ENTRYPOINT ["java", "-jar", "libraryloan.jar"]