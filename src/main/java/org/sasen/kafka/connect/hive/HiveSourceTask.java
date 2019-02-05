package org.sasen.kafka.connect.hive;

import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.source.SourceTask;
import org.apache.kafka.connect.source.SourceRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.sasen.kafka.connect.hive.util.Version;

public class HiveSourceTask extends SourceTask {
  private static final Logger log = LoggerFactory.getLogger(HiveSourceTask.class);

  private HiveSourceConnectorConfig config;

  private String hiveConnectionURL = "";
  private String hiveUser = "";
  private String hivePassword = "";
  private String hiveQuery = "";

  private String kafkaTopic = "";
  private String kafkaClientID = "";

  @Override
  public void start(Map<String, String> properties) {
    try {

      config = new HiveSourceConnectorConfig(properties);
    } catch (ConfigException e) {
      throw new ConnectException(
              "Couldn't start HiveSourceTask due to configuration error", e);
    }

    hiveConnectionURL = config.getString(HiveSourceConnectorConfig.HIVE_CONNECTION_URL_CONFIG);
    hiveUser = config.getString(HiveSourceConnectorConfig.HIVE_USER_CONFIG);
    hivePassword = config.getString(HiveSourceConnectorConfig.HIVE_PASSWORD_CONFIG);
    hiveQuery = config.getString(HiveSourceConnectorConfig.HIVE_QUERY_CONFIG);

    kafkaTopic = config.getString(HiveSourceConnectorConfig.KAFKA_TOPIC_CONFIG);
    kafkaClientID = config.getString(HiveSourceConnectorConfig.KAFKA_CLIENT_ID_CONFIG);
  }

  /**
   * Returns the version of the connector.
   *
   * @return
   */
  @Override
  public String version() {
    return Version.getVersion();
  }

  @Override
  public List<SourceRecord> poll() throws InterruptedException {
    log.trace("{} Polling for new data");
    ArrayList<SourceRecord> records = new ArrayList<>();
    try {

    } catch(Exception e) {

    }

    return records;
  }

  /**
   * Teardown function of the connector.
   */
  @Override
  public void stop() { //TODO Close SparkSession here}
}
