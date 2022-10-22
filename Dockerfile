FROM openjdk:8
EXPOSE 8090
ADD target/product-stock-microservice-1.0.jar product-stock-microservice-1.0.jar
ENTRYPOINT ["java","-jar","product-stock-microservice-1.0.jar"]