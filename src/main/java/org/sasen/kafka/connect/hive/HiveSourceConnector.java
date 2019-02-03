package org.sasen.kafka.connect.hive;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.source.SourceConnector;
import org.apache.kafka.connect.connector.Task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * HiveSourceConnector is a Kafka Connect Connector implementation that extracts data from Apache
 * Hive table into Kafka.
 */
public class HiveSourceConnector extends SourceConnector {
  private static final Logger log = LoggerFactory.getLogger(HiveSourceConnector.class);

  private Map<String, String> configProperties;

  @Override
  public String version() {
    return Version.getVersion();
  }

  @Override
  public void start(Map<String, String> properties) throws ConnectException {
    log.info("Starting Hive Source Connector");
    try {
      configProperties = properties;
    } catch (ConfigException e) {
      throw new ConnectException(
          "Couldn't start HiveSourceConnector due to configuration error", e);
    }
  }

  @Override
  public Class<? extends Task> taskClass() {
    return HiveSourceTask.class;
  }

  @Override
  public List<Map<String, String>> taskConfigs(int maxTasks) {
    List<Map<String, String>> configs = new ArrayList<>(maxTasks);
    return configs;
  }

  @Override
  public void stop() {}

  @Override
  public ConfigDef config() {}
}
