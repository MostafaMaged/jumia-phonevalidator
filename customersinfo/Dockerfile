FROM openjdk:11
ADD target/customersinfo-0.0.1-SNAPSHOT.jar customersinfo.jar
ADD ./sample.db sample.db
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "customersinfo.jar"]