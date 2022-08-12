FROM openjdk
WORKDIR usr/lib
ENV MONGO_DATABASE="mymovie"
ENV MONGO_URL="mongodb://localhost:27017/mymovie"
ADD ./target/Rest_mongo_Product-0.0.1-SNAPSHOT.jar /usr/lib/Rest_mongo_Product-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Rest_mongo_Product-0.0.1-SNAPSHOT.jar"]