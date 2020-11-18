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
	
    @GetMapping("v1/kafka/health")
    public String health(){
        return "kafka api is healthy";
    }
    
    @PostMapping("v1/kafka/produce/{topic}")
    public KafkaResponse produce(@PathVariable("topic") String topic,@RequestBody ProducerRequest req){
    	return kafkaService.publishMessage("localhost:9092", topic, req.getKey(), req.getValue());
    }
    
    @GetMapping("v1/kafka/consume/{topic}/group/{group}")
    public KafkaResponse consume(@PathVariable("topic") String topic,@PathVariable("group") String consumerGroup){
    	return kafkaService.consumeMessage("localhost:9092", topic, consumerGroup);
    }
    @PostMapping("v1/kafka/clear/{topic}")
    public KafkaResponse clear(@PathVariable("topic") String topic){
        return kafkaService.deleteMessages("localhost:9092", topic);
    }
    
    @DeleteMapping("v1/kafka/delete/{topic}")
    public KafkaResponse delete(@PathVariable("topic") String topic){
    	return kafkaService.deleteTopic("localhost:9092",  topic);
    }
}
