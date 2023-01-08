# Demo-Java-Cucumber-RestAssured-Maven

## Objective
Project to demo API test automation using following tools & technologies.

- Java
- Maven
- Cucumber Framework
- RestAssured Libraries
- **JUnit5**
- **Run tests in parallel** using Junit5
- **cucumber-picocontainer** for dependency injection
- **Hamcrest Matchers**
- Reporting using **Cluecumber** report maven plugin
- **Docker** for running tests in a container (using Dockerfile)
- API Response stubbing using **Wiremock**


## To run tests in docker

Step 1- Clone the repository

Step 2 - `cd` to the repository
```shell
cd Demo-Java-Cucumber-RestAssured-Maven
```

Step 3 - Build docker image
```shell
docker build -t ImageName .
```
- ImageName can be any name you would like to give.
- This command need to be run from directory where Dockerfile exist.

Step 4 - Run maven commands using docker
```shell
docker run -it --rm -v $(pwd):/app ImageName mvn clean test cluecumber-report:reporting
```
This command will
- run image 'ImageName' in a Container
- `--rm` will remove the container when it exits
- `-v $(pwd):/app` mounts the current working directory ($(pwd)) as /app inside the container. 
The current working directory is the repository itself (as in Step 2)
- runs maven command `mvn clean test cluecumber-report:reporting`

## To check generated cluecumber report

The report is generated under directory `target/generated-report` inside the repository. 

To open the report, open file `target/generated-report/index.html`