# DSE Java Driver

Simple SpringBoot program to exercise Java Driver capabilities. 

Build and Run
```
$ ./mvnw clean install
$ ./mvnw spring-boot:run
```

Before building you can update the [application.conf](https://github.com/mborges-pivotal/dse-java-driver/blob/main/src/main/resources/application.conf) file with the java driver settings you need to connect to your cluster. 

In the [src/main/resources](https://github.com/mborges-pivotal/dse-java-driver/tree/main/src/main/resources) you can find the default configuration files, including the application.conf and logback.xml. 