FROM maven:3.8-jdk-11
EXPOSE 8081
ADD /target/libraryoperations.jar libraryoperations.jar
ENTRYPOINT ["java", "-jar", "libraryoperations.jar"]