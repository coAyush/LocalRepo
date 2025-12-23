# Stage 1: Build using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
# This builds the WAR file based on your pom.xml settings
RUN mvn clean package -DskipTests

# Stage 2: Deploy to a Tomcat Server
FROM tomcat:10.1-jdk21
WORKDIR /usr/local/tomcat/webapps/

# IMPORTANT: We rename the output to Nexus.war so your 
# URL http://localhost:8080/Nexus/api/ coins stays valid.
COPY --from=build /app/target/*.war ./Nexus.war

EXPOSE 8080
CMD ["catalina.sh", "run"]