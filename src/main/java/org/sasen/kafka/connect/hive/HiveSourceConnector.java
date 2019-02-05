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
import java.util.HashMap;

import org.sasen.kafka.connect.hive.util.Version;

/**
 * HiveSourceConnector is a Kafka Connect Connector implementation that extracts data from Apache
 * Hive table into Kafka.
 */
public class HiveSourceConnector extends SourceConnector {
    private static final Logger log = LoggerFactory.getLogger(HiveSourceConnector.class);

    private Map<String, String> configProperties;
    private HiveSourceConnectorConfig config;

//  private String hiveConnectionURL = "";
//  private String hiveUser = "";
//  private String hivePassword = "";
//  private String hiveQuery = "";
//
//  private String kafkaTopic = "";
//  private String kafkaClientID = "";

    /**
     * Returns the version of the connector.
     *
     * @return
     */
    @Override
    public String version() {
        return Version.getVersion();
    }

    /**
     * Takes configuration from connector.properties and pass them to config class.
     *
     * @param properties
     * @throws ConnectException
     */
    @Override
    public void start(Map<String, String> properties) throws ConnectException {
        log.info("Starting Hive Source Connector");
        try {
            configProperties = properties;
            config = new HiveSourceConnectorConfig(configProperties);
        } catch (ConfigException e) {
            throw new ConnectException(
                    "Couldn't start HiveSourceConnector due to configuration error: ", e);
        }

//    hiveConnectionURL = config.getString(HiveSourceConnectorConfig.HIVE_CONNECTION_URL_CONFIG);
//    hiveUser = config.getString(HiveSourceConnectorConfig.HIVE_USER_CONFIG);
//    hivePassword = config.getString(HiveSourceConnectorConfig.HIVE_PASSWORD_CONFIG);
//    hiveQuery = config.getString(HiveSourceConnectorConfig.HIVE_QUERY_CONFIG);
//
//    kafkaTopic = config.getString(HiveSourceConnectorConfig.KAFKA_TOPIC_CONFIG);
//    kafkaClientID = config.getString(HiveSourceConnectorConfig.KAFKA_CLIENT_ID_CONFIG);
    }

    @Override
    public Class<? extends Task> taskClass() {
        return HiveSourceTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        log.info("Setting task configurations for {} workers.", maxTasks);
        List<Map<String, String>> taskConfigs = new ArrayList<>(maxTasks);
        Map<String, String> taskProperties = new HashMap<>(configProperties);
        for (int i = 0; i < maxTasks; ++i) {
            taskConfigs.add(taskProperties);
        }
        return taskConfigs;
    }

    /**
     * Teardown function of the connector.
     */
    @Override
    public void stop() {
    }

    @Override
    public ConfigDef config() {
        return HiveSourceConnectorConfig.CONFIG_DEF;
    }
}
