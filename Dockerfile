FROM maven:3.6-jdk-8-alpine

COPY src /home/clipboard-automation/src
COPY pom.xml /home/clipboard-automation
RUN mvn -f /home/clipboard-automation/pom.xml clean install -DskipTests=true
