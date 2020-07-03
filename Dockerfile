FROM openjdk:8

ADD build/libs/covid-0.0.1-SNAPSHOT.jar covid-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","covid-0.0.1-SNAPSHOT.jar"]