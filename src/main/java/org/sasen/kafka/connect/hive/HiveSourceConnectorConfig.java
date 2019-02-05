package org.sasen.kafka.connect.hive;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Recommender;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.apache.kafka.common.config.ConfigDef.Width;
import org.apache.kafka.common.config.ConfigException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class HiveSourceConnectorConfig extends AbstractConfig {
  private static final Logger log = LoggerFactory.getLogger(HiveSourceTask.class);

  public static final String HIVE_CONNECTION_URL_CONFIG = "hive.connection.url";
  private static final String HIVE_CONNECTION_URL_DOC = "Hive JDBC connection URL.";
  private static final String HIVE_CONNECTION_URL_DISPLAY = "Hive JDBC URL";

  public static final String HIVE_USER_CONFIG = "hive.user";
  private static final String HIVE_USER_DOC = "Hive User ID.";
  private static final String HIVE_USER_DISPLAY = "Hive User";

  public static final String HIVE_PASSWORD_CONFIG = "hive.password";
  private static final String HIVE_PASSWORD_DOC = "Hive Password.";
  private static final String HIVE_PASSWORD_DISPLAY = "Hive Password";

  public static final String HIVE_QUERY_CONFIG = "hive.query";
  private static final String HIVE_QUERY_DOC = "Hive Query.";
  private static final String HIVE_QUERY_DISPLAY = "Hive Query";

  public static final String KAFKA_TOPIC_CONFIG = "kafka.topic";
  private static final String KAFKA_TOPIC_DOC = "Hive Topic.";
  private static final String KAFKA_TOPIC_DISPLAY = "Hive Topic";

  public static final String KAFKA_CLIENT_ID_CONFIG = "kafka.client.id";
  private static final String KAFKA_CLIENT_ID_DOC = "Hive Client ID.";
  private static final String KAFKA_CLIENT_ID_DISPLAY = "Hive Client ID";

  public static final String KAFKA_GROUP = "Database";
  public static final String HIVE_GROUP = "Mode";

  public static ConfigDef baseConfigDef() {
    ConfigDef config = new ConfigDef();
    addKafkaOptions(config);
    addHiveOptions(config);
    return config;
  }

  private static final void addKafkaOptions(ConfigDef config) {
    int orderInGroup = 0;
    config
        .define(
            KAFKA_TOPIC_CONFIG,
            Type.STRING,
            Importance.HIGH,
            KAFKA_TOPIC_DOC,
            KAFKA_GROUP,
            ++orderInGroup,
            Width.LONG,
            KAFKA_TOPIC_DISPLAY)
        .define(
            KAFKA_CLIENT_ID_CONFIG,
            Type.STRING,
            Importance.MEDIUM,
            KAFKA_CLIENT_ID_DOC,
            KAFKA_GROUP,
            ++orderInGroup,
            Width.MEDIUM,
            KAFKA_CLIENT_ID_DISPLAY);
  }

  public static final void addHiveOptions(ConfigDef config) {
    int orderInGroup = 0;
    config
        .define(
            HIVE_CONNECTION_URL_CONFIG,
            Type.STRING,
            Importance.HIGH,
            HIVE_CONNECTION_URL_DOC,
            HIVE_GROUP,
            ++orderInGroup,
            Width.LONG,
            HIVE_CONNECTION_URL_DISPLAY)
        .define(
            HIVE_USER_CONFIG,
            Type.STRING,
            Importance.HIGH,
            HIVE_USER_DOC,
            HIVE_GROUP,
            ++orderInGroup,
            Width.LONG,
            HIVE_USER_DISPLAY)
        .define(
            HIVE_PASSWORD_CONFIG,
            Type.STRING,
            Importance.HIGH,
            HIVE_PASSWORD_DOC,
            HIVE_GROUP,
            ++orderInGroup,
            Width.LONG,
            HIVE_PASSWORD_DISPLAY)
        .define(
            HIVE_QUERY_CONFIG,
            Type.STRING,
            Importance.HIGH,
            HIVE_QUERY_DOC,
            HIVE_GROUP,
            ++orderInGroup,
            Width.LONG,
            HIVE_QUERY_DISPLAY);
  }

  public static final ConfigDef CONFIG_DEF = baseConfigDef();

  public HiveSourceConnectorConfig(Map<String, ?> properties) {
    // Parse and validate configs.
    super(CONFIG_DEF, properties);
  }
}
