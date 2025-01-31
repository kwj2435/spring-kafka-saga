FROM openjdk:17-jdk-alpine
  
WORKDIR /app

COPY build/libs/*.jar inventory-service.jar
  
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "inventory-service.jar"]