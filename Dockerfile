FROM openjdk:17-jdk-alpine
COPY build/libs/NotifierApp-0.0.1.jar NotifierApp-0.0.1.jar
ENTRYPOINT ["java","-jar","/NotifierApp-0.0.1.jar"]
EXPOSE 8081