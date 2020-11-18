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


### Setup of UI on my machine :

- To find cluster state :
![image](https://user-images.githubusercontent.com/61533898/99568613-ae202280-29f5-11eb-8b3a-f8d28d6a9f32.png)

- To find cluster load :
![image](https://user-images.githubusercontent.com/61533898/99568908-fa6b6280-29f5-11eb-86cc-adf706f49ac2.png)

- Adminsitrative operations :
![image](https://user-images.githubusercontent.com/61533898/99568976-15d66d80-29f6-11eb-8be4-6dac0e947109.png)


### Sample experiment on rebalancing of cluster :

- Bring in a new node into the cluster. The new node has no topics with it
![image](https://user-images.githubusercontent.com/61533898/99570001-54205c80-29f7-11eb-8404-d203e32789d6.png)

- Now do Add Broker/remove broker admin activity 
![image](https://user-images.githubusercontent.com/61533898/99570141-8631be80-29f7-11eb-97a5-8f06201a1091.png)


![image](https://user-images.githubusercontent.com/61533898/99570569-238cf280-29f8-11eb-9230-734c50cf9064.png)

-  Now lets see the result 
![image](https://user-images.githubusercontent.com/61533898/99570708-59ca7200-29f8-11eb-9c25-64c5418b3613.png)

All the four brokers have almost equal share of leaders and partitions

### Summarise :

CruiseControl gives lot of scope for reduction of manual effort along with its wonderful UI which has details along with valid metrics as well as various operations which can be auto done or manually done but with very little effort. This also resolves human error. For example a simple partition re-assignment which would take hours could be completed within few hours just monitoring.

