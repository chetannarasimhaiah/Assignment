# Requirement

Explore Cruise control – open source plug-in and develop a POC for your Kafka clusters

## Introduction :

Kafka Cruise Control is designed to address this operation scalability issue.
Kafka Cruise Control provides the following features out of the box:

- Kafka broker resource utilization tracking
- The ability to query the latest replica state (offline, URP, out of sync) from brokers
- Goal-based resource distribution
- Anomaly detection with self-healing
- Admin operations on Kafka (add/remove/demote brokers, rebalance cluster, run PLE)

Resource utilization tracking for brokers, topics, and partitions.

Query the current Kafka cluster state to see the online and offline partitions, in-sync and out-of-sync replicas, replicas under min.insync.replicas, online and offline logDirs, and distribution of replicas in the cluster.

Multi-goal rebalance proposal generation for:

Rack-awareness
Resource capacity violation checks (CPU, DISK, Network I/O)
Per-broker replica count violation check
Resource utilization balance (CPU, DISK, Network I/O)
Leader traffic distribution
Replica distribution for topics
Global replica distribution
Global leader replica distribution
Custom goals that you wrote and plugged in
Anomaly detection, alerting, and self-healing for the Kafka cluster, including:

Goal violation
Broker failure detection
Metric anomaly detection
Disk failure detection (not available in kafka_0_11_and_1_0 branch)
Admin operations, including:

Add brokers
Decommission brokers
Demote brokers
Rebalance the cluster
Fix offline replicas (not available in kafka_0_11_and_1_0 branch)
Perform preferred leader election (PLE)
Fix offline replicas


## Architecture for Assignment :

![image](https://user-images.githubusercontent.com/61533898/99422242-59ad7200-2925-11eb-8eb2-9b0003c27ed8.png)

## Planned POC :

### Do Admin activities such as 
- Add Brokers. 
- Decommission Brokers.
- Demote Brokers.
- Rebalance the cluster.

### Setup CruiseControl UI
- Use UI to do these activities.

## Activity pipeline plan :
 - Download Cruisecontrol api and cruisecontrol UI.
 - Set up cruisecontrol api and UI configuration to map to that of a kafka broker cluster.
 - Start Cruisecontrol
 - Verify the setup by visiting the cruisecontrol UI/or through postman API call.

