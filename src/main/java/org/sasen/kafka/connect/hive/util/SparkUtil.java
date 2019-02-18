package org.sasen.kafka.connect.hive.util;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class SparkUtil {
  // Private constructor here prevents the instantiation of this class directly.
  private SparkUtil() {}

  private static final Logger log = LoggerFactory.getLogger(SparkUtil.class);

  private static SparkSession getSparkSession() {
    log.info("Getting Spark session...");
    SparkSession sparkSession = SparkSession
            .builder()
            .appName("Hive Source Connect")
            .enableHiveSupport()
            .getOrCreate();
    return sparkSession;
  }

  private static void closeSparkSession(SparkSession sparkSession) {
    log.info("Closing Spark session...");
    sparkSession.close();
  }

  public static Dataset runHiveQuery(String hiveQuery) {
    SparkSession sparkSession = SparkUtil.getSparkSession();
    sparkSession.sql(hiveQuery);
    //return
  }
}
