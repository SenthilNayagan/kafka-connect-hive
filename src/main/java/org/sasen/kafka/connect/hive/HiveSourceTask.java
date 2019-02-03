package org.sasen.kafka.connect.hive;

import org.apache.kafka.connect.source.SourceTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class HiveSourceTask extends SourceTask {
  private static final Logger log = LoggerFactory.getLogger(HiveSourceTask.class);

  @Override
  public void start(Map<String, String> properties) {}
}
