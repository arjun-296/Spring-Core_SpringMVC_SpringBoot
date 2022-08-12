FROM openjdk
WORKDIR usr/src
EXPOSE 7979
ADD ./target/authenticationWithRest-0.0.1-SNAPSHOT.jar /usr/src/authenticationWithRest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","authenticationWithRest-0.0.1-SNAPSHOT.jar"]