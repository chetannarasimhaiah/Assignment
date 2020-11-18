# AWS SQS - SNS 

## SQS (Simple Queue Services) SNS (Simple Notification Services)

SQS  | SNS
---- | -----
Queueing service for message processing | Publisher/Subscriber system
A system must poll the queue to discover new events. | Publishing messages to a topic can deliver to many subscribers of different type
Messages in the queue are typically processed by a single consumer | 
Does your system care about an event? | Do other systems care about an event?


