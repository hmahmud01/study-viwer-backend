# study-viwer-backend

### Developed in Spring Boot
A simple Study Viewer backend which will provide apis to add, update and list down the registered stuy list. 

Project Requirements:
- java 16.0.1
- Spring Boot 2.5.0
- gradle as build wrapper
- postgresql

How to run the Project Guide

## BUILD GUIDE

Before going through the build guide follow the DB SETUP and Application Configuration guide first.

- Clone this repo first `https://github.com/hmahmud01/study-viwer-backend`
- cd to root project folder
- run this command `gradlew build`
- there will be a directory titled as build will be created inside root folder
- cd into build/libs
- a jar file will be createdi with the name StudyViewer-0.0.1-SNAPSHOT.jar

Project build steps completes here.

## DB SETUP GUIDE

Make there is postgresql driver already installed in the OS. Otherwise follow the links to install postgresql drivers

- [Postgresql for Windows](https://www.enterprisedb.com/downloads/postgresql)
- [Postgresql for MAC](https://postgresapp.com/downloads.html)

After Installing the driver make sure its running and follow the steps.

- create a user with the name "postgres" and set password "1234"
- create a database named "study"
- grant all priviledges to this db for user postgres

Database Setup step completes here. Follow the application configuration to connect the database to the application

## Application Configuration

Find the file application.properties inside `~/project-root/src/main/resources/application.properties`
Make sure the following properties are filled with appropriate values and configuration
- Fill up the data source url here `spring.datasource.url=jdbc:postgresql://localhost:5432/study` change the port address if there is any other port you prefer.
- set db username `spring.datasource.username=postgres` chanage the username here if there is any other username.
- set db password `spring.datasource.password=1234` change the password here if there is any other password or if there is none.

Project Configuration Completes here.
Now CD into project root folder. and follow the build guide already given earlier.
To run the application run this command `gradlew bootRun`

To run the jar file cd into the directory where the jar snapshot is located.(default url will be `~projectroot/build/libs`)
run the command `java -jar StudyViewer-0.0.1-SNAPSHOT.jar`

# IntelliJ IDEA Guide
If you are Using Jetbrains IDE which is IntelliJ IDEA Follow the Steps given below.
1. Complete the DB SETUP and application configuration setup
2. press the green Play button in the top bar to run the project
3. Find the Gradle toolbar. 
4. Uncollapse the toolbar to get the gradle task list
5. find the build task inside StudyViewer > Tasks > build > build
6. Run the task to build the project.
7. Find the jar file inside `build/lib` and run `java -jar StudyViewer-0.0.1-SNAPSHOT.jar`

Project Documentation completes here. If there is any problem or confusion please email me here "hmahmud01@gmail.com"

Thanks-
Hasan Mahmud
