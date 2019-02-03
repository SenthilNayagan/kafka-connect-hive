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
