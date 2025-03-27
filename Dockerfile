FROM openjdk:17-jdk-slim
  
WORKDIR /app
  
COPY build/libs/creditSimulator-*.jar app.jar

RUN ls -l /app
  
CMD ["java", "-jar", "app.jar"]