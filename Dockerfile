FROM maven:latest

# Create a working directory
RUN mkdir -p /app
WORKDIR /app

# Copy the pom.xml file and the source code
COPY pom.xml .
COPY src/ /app/src/