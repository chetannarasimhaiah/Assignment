# AWS SQS - SNS 

## SQS (Simple Queue Services) SNS (Simple Notification Services)

SQS  | SNS
---- | -----
Queueing service for message processing | Publisher/Subscriber system
A system must poll the queue to discover new events. | Publishing messages to a topic can deliver to many subscribers of different type
Messages in the queue are typically processed by a single consumer | Multiple subscribers
Does your system care about an event? | Do other systems care about an event?
Two Queue types Standard and FIFO | 
Standard queue gives High throughput, no ordering of messages, does not gurantee exactly once delivery | 
FIFO quarantees but with lower throughput |
 | Pub/Sub natively supports both fan-in
subscriber application initiates requests to the Pub/Sub server to retrieve messages, similar to Amazon SQS. | Pub/Sub (SNS) initiates requests to your subscriber application to deliver messages.



