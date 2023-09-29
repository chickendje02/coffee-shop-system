FROM adoptopenjdk/openjdk11:latest
WORKDIR /app
COPY target/coffee-shop-service-0.0.1.jar coffee-shop-service-0.0.1.jar
EXPOSE 8081
CMD ["java","-jar","coffee-shop-service-0.0.1.jar"]