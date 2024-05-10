package com.vroozi.kafka;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.ConnectRecord;

import java.util.Map;

public interface Transformation<R extends ConnectRecord<R>>{

  R apply(R record);

  ConfigDef config();

  void close();
  
  void configure(Map<String, ?> configs);
  
}
