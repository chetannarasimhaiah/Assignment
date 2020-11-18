package com.lowes.kafka.api.domain;

import java.util.ArrayList;
import java.util.List;

public class KafkaResponse {
	private boolean status;
	private String error;
    private List<KafkaMessage> messages=new ArrayList<KafkaMessage>();
	
	
	
	public List<KafkaMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<KafkaMessage> messages) {
		this.messages = messages;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	

	
}
