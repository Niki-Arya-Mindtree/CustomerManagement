FROM maven:latest
COPY . .
COPY /pom.xml /pom.xml
COPY /target/Customer-database-1.jar app.jar
CMD java -jar app.jar