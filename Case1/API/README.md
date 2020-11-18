# Requirement :

- Write a Rest API to publish and Consumer the messages.
- Write a API using Kafka API to Delete the messages within the give Kafka and Delete the topic

## Details :

The API should be a restful API which is exposed to the user, mainly application users using which they can perform various operations like publishing/consuming/deleting messages etc. This can also be used for admin activities as well for performing various admin activities such as Delete messages, delete topic, alter configuration of topics, alter/create acls and various cluster operations.

## Design :

## MVP :
This simple restful API does these operations in its simplest nature
- Produce message to a kafka topic.
- Consume message from a kafka topic.
- Delete a topic from a kafka cluster.
- Delete messages from a kafka given kafka topic.

- Restful postman endpoints are already provided.
