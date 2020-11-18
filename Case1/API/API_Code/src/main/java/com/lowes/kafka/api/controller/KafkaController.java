/******************************************************************/
/*This controller class creates and expose the restful end points */
/* Creating five different end points for for now */
/*1. Heatlh of this api*/
/*2. Produce message to kafka topic*/
/*3. Consume message from kafka topic*/
/*4. Delete a kafka topic*/
/*5. Delete/empty all messages in kafka topic*/
/******************************************************************/

package com.lowes.kafka.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowes.kafka.api.Service.KafkaService;
import com.lowes.kafka.api.domain.KafkaResponse;
import com.lowes.kafka.api.domain.ProducerRequest;

@RestController
public class KafkaController {

	@Autowired
	KafkaService kafkaService;

		//creating health end point
    @GetMapping("v1/kafka/health")
    public String health(){
        return "kafka api is healthy";
    }

		//Creating post call for produce message end point
    @PostMapping("v1/kafka/produce/{topic}")
    public KafkaResponse produce(@PathVariable("topic") String topic,@RequestBody ProducerRequest req){
    	return kafkaService.publishMessage("localhost:9092", topic, req.getKey(), req.getValue());
    }

		//Create get call for consume end point
    @GetMapping("v1/kafka/consume/{topic}/group/{group}")
    public KafkaResponse consume(@PathVariable("topic") String topic,@PathVariable("group") String consumerGroup){
    	return kafkaService.consumeMessage("localhost:9092", topic, consumerGroup);
    }

		//create post call for clearing messages in kafka
    @PostMapping("v1/kafka/clear/{topic}")
    public KafkaResponse clear(@PathVariable("topic") String topic){
        return kafkaService.deleteMessages("localhost:9092", topic);
    }

		//create delete end point for deleting a particular topic
    @DeleteMapping("v1/kafka/delete/{topic}")
    public KafkaResponse delete(@PathVariable("topic") String topic){
    	return kafkaService.deleteTopic("localhost:9092",  topic);
    }
}
