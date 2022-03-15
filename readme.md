# Kafein Movie Manager POC

This project is POC example of Movie DB integration project

## RUNNING PROJECT ON LOCAL

In comment line you can use this script for running jar. But first you run below script
```bash
mvn clean install
```

than you go to **target** folder and run below script.

```bash
java -jar movie-manager-0.0.1-SNAPSHOT.jar
```

## DEBUGGING PROJECT ON LOCAL

### On Eclipse

Right click on 'MovieManagerApplication.java' and click 'debug as --> debug configuration'. Then open window find 'Java Application' right click and click 'New'.
Coming window you must set main class in project 'MovieManagerApplication.java' and now you can start debugging your project

### On Intellij Idea

Click 'Edit Configuration' than click '+' button and search 'Spring Boot'.
Opening window you must set main you must set main class in project 'MovieManagerApplication.java' and  now you can start debugging your project


## Service Links from local

```
Rest Swagger documentations --> http://localhost:8080/swagger-ui.html
```

## Database

You can access [H2 Db console page](http://localhost:8080/h2-console/login.jsp). Username and password are in application.properties.
