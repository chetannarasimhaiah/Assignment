# Requirement :

How we can build a abstraction layer on top of Event processing and user will have only 2 API’s - Consumer or Producer API, user should not aware what we were using in the back-ground, today it might be Kafka and in future it might be Pulsar… User should not have any impact

## Wrapper :

### Understanding :

The idea behing this requirement is to build an abstraction layer for event processing w.r.t applications wherein they need not have to worry about the messaging layer/technology being used.

![image](https://user-images.githubusercontent.com/61533898/99494211-a2514380-2996-11eb-89e5-c1e4febc2b37.png)

- Build a wrapper class and provide jar file that can be embedded into any event processing application.
- Based on the messaging event platform used be it kafka or pulsar the jar file used will be different.
- The application team will need to provide common details be it any messaging platform being used.

### Sample view
```
/*
 Producer simpleProducer=ProducerFactory().getProducer();
 
 ProducerFactory{
     
     getProducer(){
         
          * Based on what JAR files available in project
          * Based of flag in application.props 
          
         
         return Kafka/pulsar Producer;
         }
     
         }
         
         
         
         KafkaProducer implements producer {
     
           send(topic , key , value ){
               Actual Kafka producer 
         }
     
         consume(topic, groupid){
               Actual Kafka consumer
         }
         }
 
         PulsarProducer implements producer {
 
         send(topic , key , value ){
         Actual pulsar producer
         }
         }
         
         */
```
