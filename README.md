# DSE Java Driver

Simple SpringBoot program to exercise Java Driver capabilities. 

## Build and Run
```
$ ./mvnw clean install
$ ./mvnw spring-boot:run
```

## Endpoints
Once the application is running, by default on port 8080, you can hit the endpoints below to test either the DSE or OSS driver.

```
/api/dse/version 
/api/dse-oss/version
```

## For Cassandra OSS drivers
Before building you can update the [application.conf](https://github.com/mborges-pivotal/dse-java-driver/blob/main/src/main/resources/application.conf) file with the java driver settings you need to connect to your cluster. 

In the [src/main/resources](https://github.com/mborges-pivotal/dse-java-driver/tree/main/src/main/resources) you can find the default configuration files, including the application.conf and logback.xml. 

## For DSE Drivers
For DSE Driver we are using the SpringBoot [application.properties](https://github.com/mborges-pivotal/dse-java-driver/blob/main/src/main/resources/application.properties) file. 
[Java Driver for DataStax Enterprise Manual](https://docs.datastax.com/en/developer/java-driver-dse/2.3/) For more information