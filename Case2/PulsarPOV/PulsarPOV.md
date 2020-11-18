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

