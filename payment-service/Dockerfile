FROM openjdk:17-jdk-alpine
  
WORKDIR /app

COPY build/libs/*.jar payment-service.jar
  
EXPOSE 8080
  
ENTRYPOINT ["java", "-jar", "payment-service.jar"]