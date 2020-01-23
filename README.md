What is that
============
Code produced to check the technical feasibility of reading a topic
events from Kafka from java code.

This project is the part that consumes the events in Kafka.

The framework is based on
=========================
- springframework.boot: to save time and quickly create an application executable on RHEL
- org.apache.kafka: which allows to open the connection with the Kafka machine, connect to topics and read their content
- springframework.kafka: which saves time for everything concerns the use of Kafka in a Spring project

The components of this project are
==================================
- a src/main/resources/application.properties file which contains the address of the Kafka machine and the name of the topic to listen to
- src/main/java/com/ame/messages/SubscribedReader.java: which is the main java class, it launch the connection to the Kafka machine and to the topic and especially it realizes topic reading and displaying System.out for each messages
- src/main/java/com/ame/messages/config/ConsumerChannelConfig.java: which is the java class in which we find the methods that perform access to the Kafka machine and to the topic

The project opens on Eclipse or IntelliJ.

To build for the first time
===========================

`mvn clean install -U`

To execute the project, two possibilities
=========================================
Method 1
--------
- Copy the sources on an RHEL, go to the directory where is located
the pom of the project namely kafka_consumer and type the command:

`mvn clean install -U spring-boot:run -Dspring.kafka.consumer.group-id="consumer1" -Drun.arguments="AME"`

- the argument spring.kafka.consumer.group-id allows to execute several consumers
- the argument run.arguments allows you to choose what type of event you want listen
- to use method 1: you must have maven on the RHEL machine

Method 2
--------
- Build a jar and copy it to the RHEL machine, go to the directory
where the jar is and type the following command:

`nohup java -jar kafka_consumer.jar -Dspring.kafka.consumer.group-id="consumer1" -Drun.arguments="AME" &`
    
