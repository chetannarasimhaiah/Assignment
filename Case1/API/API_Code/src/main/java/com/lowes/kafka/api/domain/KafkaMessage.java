package com.lowes.kafka.api.domain;

public class KafkaMessage {
	private long offset;
	private long partition;
	private String key;
	private String value;
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		this.offset = offset;
	}
	public long getPartition() {
		return partition;
	}
	public void setPartition(long partition) {
		this.partition = partition;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
