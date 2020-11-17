# Requirement

- Install Kafka Cluster with Zookeeper enabled
- Have a Kafka cluster on both the region / Datacentre and configure Mirror making (Open source)

## High level Design plan

### Setting up kafka cluster on two data centers :
- Download opensource Apache kafka 2.6.x and Apache Zookeeper 3.4.x
- Create two data centres named DC1 and DC2
- Each Data center will have 3 nodes each of zookeeper and kafka
- Each zookeeper node in a data center will have specific configurations.
- Each Kafka node in a data center will have specific configurationss.
- Set up and start first zookeeper and once the services are up and running.
- Start kafka brokers and validate the kafka servers and make sure cluster is healthy.
- Follow the same in other data centers.
- Create topics and validate with simple cli producer/consumer

### Setting up Mirroring between two data centers:

- Set up mirroring configurations for both producer and consumer.
- Set up mirroring service at destination Data center.
- Start mirroring service.
- Validate mirroring between source and destination Data centers.


### Architecture


