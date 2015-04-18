FROM dockerfile/java:oracle-java8 

COPY micro-service-extraction.jar /opt/micro-service-extraction.jar

# Define default command.
CMD ["java","-jar","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","/opt/micro-service-extraction.jar"]