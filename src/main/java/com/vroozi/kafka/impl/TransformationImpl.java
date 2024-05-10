package com.vroozi.kafka.impl;

import com.vroozi.kafka.Transformation;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.ConnectRecord;

import java.util.Map;

public class TransformationImpl<R extends ConnectRecord<R>> implements Transformation<R> {
  
  @Override
  public R apply(R record) {
    
    // Your transformation logic here
    // Example: Convert the value to uppercase
    String transformedValue = ((String) record.value()).toUpperCase();
    return record.newRecord(
        record.topic(),
        record.kafkaPartition(),
        record.keySchema(),
        record.key(),
        record.valueSchema(),
        transformedValue,
        record.timestamp()
    );
  }
  
  @Override
  public ConfigDef config() {
    return new ConfigDef();
  }
  
  @Override
  public void close() {
    // Clean up any resources
  }
  
  @Override
  public void configure(Map<String, ?> configs) {
  
  }
}
