# AWS SQS - SNS 

## SQS (Simple Queue Services) SNS (Simple Notification Services)

### Basic Differences

SQS  | SNS
---- | -----
Queueing service for message processing | Publisher/Subscriber system
A system must poll the queue to discover new events. | Publishing messages to a topic can deliver to many subscribers of different type
Messages in the queue are typically processed by a single consumer | Multiple subscribers
Does your system care about an event? | Do other systems care about an event?
Two Queue types Standard and FIFO | 
Standard queue gives High throughput, no ordering of messages, does not gurantee exactly once delivery | 
FIFO quarantees but with lower throughput |
. | Pub/Sub natively supports both fan-in
subscriber application initiates requests to the Pub/Sub server to retrieve messages, similar to Amazon SQS. | Pub/Sub (SNS) initiates requests to your subscriber application to deliver messages.
. | SNS supports several end points such as email, sms, http end point and SQS. 
SQS is mainly used to decouple applications or integrate applications. | SNS distributes several copies of message to several subscribers.
Messages can be stored in SQS for short duration of time (max 14 days) | 


### Categories and comparisions :

Category | SQS | SNS
-------- | --- | ---
Entity Type | Queue (Similar to JMS) | Topic (Pub/Sub system)
Message consumption | Pull Mechanism - Consumers poll and pull messages from SQS | Push Mechanism - SNS Pushes messages to consumers
Use Case | Decoupling 2 applications and allowing parallel asynchronous processing | Fanout - Processing the same message in multiple ways
Reliability | A large volume of data can be sent. Because of the application decoupling component, only a particular application component is effected in case of any failure rather than disturbing the whole process. | he messages are dependent on the availability of SNS Topics. In this case any error from subscriber endpoints initiatives like message retry policies etc.
Scalability | Can be scaled easily | Can be scaled as well.
Persistence | Messages are persisted for some (configurable) duration if no consumer is available (max 2 weeks), so consumer does not have to be up when messages added to queue. | No persistence. Whichever consumer is present at the time of message arrival gets the message and the message is deleted. If no consumers are available then the message is lost after a few retries.
Consumer Type | each message is processed once by one consumer, hence process the messages in exact same way | The consumers might process the messages in different ways
Sample applications | Jobs framework: The Jobs are submitted to SQS and the consumers at the other end can process the jobs asynchronously. If the job frequency increases, the number of consumers can simply be increased to achieve better throughput. | Image processing. If someone uploads an image to S3 then watermark that image, create a thumbnail and also send a Thank You email. In that case S3 can publish notifications to a SNS Topic with 3 consumers listening to it. 1st one watermarks the image, 2nd one creates a thumbnail and the 3rd one sends a Thank You email. All of them receive the same message (image URL) and do their processing in parallel.
Pricing | No Charges for first 1million request. Post that 0.40$ to 0.50$ based on queue type for a million request. | No Charges for first 1million request. Post that price varies on type of subscriptions.


### Simple architecture:

#### SQS :

![image](https://user-images.githubusercontent.com/61533898/99518155-37b00000-29b6-11eb-8655-15d117cd6b42.png)

#### SNS :

![image](https://user-images.githubusercontent.com/61533898/99518232-4d252a00-29b6-11eb-9983-7f52a10d39c3.png)


