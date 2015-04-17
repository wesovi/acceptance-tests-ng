FROM dockerfile/java:oracle-java8 

COPY micro-service-extraction.jar /opt/micro-service-extraction.jar

# Define default command.

RUN apt-get install -y git
RUN apt-get install -y maven

RUN cd /opt ; git clone $REPO ; git checkout $REPO_BRANCH ; mvn verify

CMD ["java","-jar","-Dspring.profiles.active=docker","/opt/micro-service-extraction.jar"]