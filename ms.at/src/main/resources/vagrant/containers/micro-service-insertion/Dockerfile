FROM dockerfile/java:oracle-java8 

COPY micro-service-insertion.jar /opt/application.jar

# Define default command.
CMD ["java","-jar","-Dspring.profiles.active=docker","/opt/application.jar"]