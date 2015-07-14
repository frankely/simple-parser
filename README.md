# README (THIS IS JUST A EXCERCISE) DO NOT USE THIS

This README would normally document whatever steps are necessary to get your application up and running.


## Prerequisites 

* Java 6 SDK
* Maven 3.0


## Run Tests 

Run the following command in the project root folder where is located pom.xml

```
mvn test

```

## Run Console App

In order to use the App you have to run the following command from the root folder of the project in your terminal/command line.

You must replace the arguments for the path of each of your files (comma.txt, pipe.txt, space.txt)

```java
java -cp target/classes/ Main "<comma_file_path>" "<pipe_file_path>" "<space_file_path>"
```

