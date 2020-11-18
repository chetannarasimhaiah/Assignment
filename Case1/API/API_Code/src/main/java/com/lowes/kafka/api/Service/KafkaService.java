package com.lowes.kafka.api.Service;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.AlterConfigsResult;
import org.apache.kafka.clients.admin.Config;
import org.apache.kafka.clients.admin.ConfigEntry;
import org.apache.kafka.clients.admin.DeleteTopicsResult;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.config.ConfigResource;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.stereotype.Service;

import com.lowes.kafka.api.domain.KafkaMessage;
import com.lowes.kafka.api.domain.KafkaResponse;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class KafkaService {

    public KafkaResponse publishMessage(String brokerUrl,String topic,String key,String value){
    	
    	KafkaResponse response=new KafkaResponse();
    	
        Properties props = new Properties();
        props.put("bootstrap.servers", brokerUrl);
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String,String>(props);
        Future<RecordMetadata> result=producer.send(new ProducerRecord<String, String>(topic, key,value));
        while(result.isDone()==false) {
        	System.out.println("Waiting for producer to send message to broker");
        }
        
        try {
        	response.setStatus(true);
        	KafkaMessage message=new KafkaMessage();
        	message.setOffset(result.get().offset());
        	message.setPartition(result.get().partition());
        	message.setKey(key);
        	message.setValue(value);
        	response.getMessages().add(message);
		} catch (InterruptedException | ExecutionException e) {
			response.setStatus(false);
			response.setError("Not able to send message "+e.getMessage());
			System.out.println("Error in sending data to kafka");
			e.printStackTrace();
		}        
            
        producer.close();

        return response;
    }
    public KafkaResponse consumeMessage(String brokerUrl,String topic,String consumerGroup){
    	
    	KafkaResponse response=new KafkaResponse();
    	
    	 Properties props = new Properties();
         props.put("bootstrap.servers", brokerUrl);
         props.put("group.id", consumerGroup);
         props.put("enable.auto.commit", "true");
         props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
         props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
         
         KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
         
         consumer.subscribe(Arrays.asList(topic));
         
         response.setStatus(true);
         
         int retry=10;
         while(retry>0) {
        	 --retry;
         
             ConsumerRecords<String, String> records = consumer.poll(1000);
             if(records.count()>0)
            	 retry=0;
             for (ConsumerRecord<String, String> record : records) {
            	 System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            	 KafkaMessage message=new KafkaMessage();
             	message.setOffset(record.offset());
             	message.setPartition(record.partition());
             	message.setKey(record.key());
             	message.setValue(record.value());
             	response.getMessages().add(message);
             }
             
             try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
         consumer.close();
                
        return response;
    }

    public KafkaResponse deleteTopic(String brokerUrl,String topic){
    	
    	KafkaResponse response=new KafkaResponse();
    	
    	
    	  Properties config = new Properties();
          config.put("bootstrap.servers", brokerUrl);
          AdminClient admin = AdminClient.create(config);
          List<String> topicsToDelete=new ArrayList<String>();
          topicsToDelete.add(topic);
          
          DeleteTopicsResult result=admin.deleteTopics(topicsToDelete); 
          response.setStatus(true);
        return response;
    }
    
    public KafkaResponse deleteMessages(String brokerUrl,String topic){
    	KafkaResponse response=new KafkaResponse();
    	
    	
  	  Properties brokerConfig = new Properties();
  	  brokerConfig.put("bootstrap.servers", brokerUrl);
  	  
      AdminClient admin = AdminClient.create(brokerConfig);
        
      ConfigResource configResource = new ConfigResource(ConfigResource.Type.TOPIC, topic);
      
      List<ConfigEntry> entries = new ArrayList<>();
      entries.add(new ConfigEntry(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(0)));  
        
     
        Config topicConfig = new Config(entries);
        
        Map<ConfigResource, Config> alterConfigs = new HashMap<ConfigResource, Config>();
        
        alterConfigs.put(configResource, topicConfig);  
       
        AlterConfigsResult result=admin.alterConfigs(alterConfigs);
        
        try {
        	Thread.sleep(10000);
        }catch(Exception e) {
        	
        }
        
        //reset retention back to 4 hours 
        
       
        
        entries = new ArrayList<>();
        entries.add(new ConfigEntry(TopicConfig.RETENTION_MS_CONFIG, String.valueOf("14400000")));  
        topicConfig = new Config(entries);
        alterConfigs = new HashMap<ConfigResource, Config>();
        
        alterConfigs.put(configResource, topicConfig);
        result=admin.alterConfigs(alterConfigs);
        response.setStatus(true);
        		
      return response;
  }

}
