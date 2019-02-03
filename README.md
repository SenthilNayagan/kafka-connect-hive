# Kafka Connect Connector for Hive

This connector extracts data from Apache Hive table into Kafka. Based on the given Hive SQL query, the data from Hive table will be extracted and put them into the given Kafka Topic.

# Configuration

```properties
# Set these required Kafka values
kafka.topic=my-topic
kafka.client.id=my-id

# Set these required Hive values
hive.connection.url=https://connect-to-hive-jdbc
hive.user=guest
hive.password=pass
hive.query=select * from db.table where col1 > 20
``` 

# Development
To build a development version you'll need a recent and stable version of Kafka. You can build kafka-connect-hive with Maven.

```aidl
mvn clean && mvn install -DskipTests -Dfile.encoding=UTF-8
cp target/kafka-connect-hive-1.0-SNAPSHOT.jar /path to confluent director/share/java/kafka-connect-hive/
```