FROM openjdk:17-jdk-alpine
  
WORKDIR /app

COPY build/libs/*.jar order-service.jar
  
EXPOSE 8081
  
ENTRYPOINT ["java", "-jar", "order-service.jar"]