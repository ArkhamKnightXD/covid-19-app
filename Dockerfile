FROM openjdk:8

ADD build/libs/gamestop-0.0.1-SNAPSHOT.jar gamestop-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","gamestop-0.0.1-SNAPSHOT.jar"]