FROM openjdk:11
COPY build/libs/NotifierApp-0.0.1.jar NotifierApp-0.0.1.jar
ENTRYPOINT ["java","-jar","/NotifierApp-0.0.1.jar"]
EXPOSE 8081