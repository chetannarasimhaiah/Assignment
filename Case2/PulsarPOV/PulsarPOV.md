# Understand Pulsar and differences between apache pulsar and apache kafka

## Overview of pulsar
Pulsar is a multi-tenant, high-performance solution for server-to-server messaging. Pulsar is built on the publish-subscribe pattern (short for pub-sub). In this pattern, producers publish messages to topics. Consumers subscribe to those topics, process incoming messages, and send an acknowledgement when processing is complete.


### Architecture :

Key Componenets are Brokers, Bookeeper and zookeeper

![image](https://user-images.githubusercontent.com/61533898/99557523-cccbec80-29e8-11eb-9123-90642248d2ad.png)

### Key features of pulsar :

- multiple clusters in a Pulsar instance, with seamless geo-replication of messages across clusters.
- Very low publish and end-to-end latency.
- Seamless scalability to over a million topics.
- Multiple subscription modes for topics.
- Guaranteed message delivery with persistent message storage provided by Apache BookKeeper.
- A serverless light-weight computing framework Pulsar Functions offers the capability for stream-native data processing.
- A serverless connector framework Pulsar IO, which is built on Pulsar Functions, makes it easier to move data in and out of Apache Pulsar.
- Batching and chunking of messages.


### Key componenets of pulsar :

- Messages.
- Producer.
- Consumer.
- Topics - Normal topics and partitioned topic

### Pub sub model of pulsar :

Types :
- Exclusive
- Failover
- Shared
- Key_Shared
- Multi topic subscription

![image](https://user-images.githubusercontent.com/61533898/99555738-a5742000-29e6-11eb-9f93-65c18104941d.png)


### Message Retention and expiry :

Pulsar message brokers:

immediately delete all messages that have been acknowledged by a consumer, and
persistently store all unacknowledged messages in a message backlog.
Pulsar has two features, however, that enable you to override this default behavior:

Message retention enables you to store messages that have been acknowledged by a consumer
Message expiry enables you to set a time to live (TTL) for messages that have not yet been acknowledged


# Bring in view about pulsar vs kafka

Kafka | Pulsar
----- | -----
Kafka is an open-source distributed event streaming platform | Pulsar is an open-source distributed pub/sub messaging system originally catered towards queuing use cases.
Kafka is designed as a replicated, distributed, persistent commit log that is used to power event-driven microservices or large-scale stream processing applications. | stateless broker instances that connect to a separate tier of BookKeeper instances, which actually read/write and, optionally, store/replicate the messages durably.
Kafka is lightweight and with zookeeper removal makes it movable easily | Pulsar comes in with bookkeeper based architecture.
Clients produce or consume events directly to/from a cluster of brokers, which read/write events durably to the underlying file system and also automatically replicate the events synchronously or asynchronously within the cluster for fault tolerance and high availability. | Pub-Sub model with multiple producer and consumers.
Kafka’s replication protocol was carefully designed to ensure consistency and durability guarantees without the need for synchronous fsync by tracking what has been fsynced to the disk and what hasn’t. Kafka can handle a wider range of failures like filesystem-level corruptions or accidental disk de-provisioning and does not take for granted the correctness of data that is not known to be fsync’d. Kafka is also able to leverage the OS for batching writes to the disk for better performance. | Whether BookKeeper offers the same consistency guarantees without fsyncing each write—specifically, whether it can rely on replication for fault tolerance in the absence of synchronous disk persistence.
No Additional disks set up | Pulsar requires disk set up for journaling and one for ledger storage
Less memory Tuning issue as it is easy to tune | pulsar as well as bookkeeper bookies rely on off-heap/direct memory for caching and this needs more effort to avoid out of memory issue.
Higher throughput, twice of pulsar | Lower throughput
Lower Latency | Higher Latency


### Observations :

- Pulsar has only limited support for message queuing because it misses popular messaging features like message XA transactions, routing, message filtering, etc. that are commonly used with messaging systems like IBM MQ, RabbitMQ, and ActiveMQ. 
- Pulsar has only limited support for event streaming. For example, it does not support exactly-once delivery and processing semantics, which disqualifies it for most use cases in practice
