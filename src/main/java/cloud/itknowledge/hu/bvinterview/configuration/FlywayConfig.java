/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview.configuration;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zoltán.Katona
 *
 */
@Configuration
public class FlywayConfig {

  private static final Logger LOG = LoggerFactory.getLogger(FlywayConfig.class);

  @Bean
  public Flyway flyway(DataSource dataSource) {
    LOG.info("Initializing flyway bean in FlywayConfig...");
    Flyway flyway = new Flyway();
    flyway.setDataSource(dataSource);
    flyway.setSchemas(DbMonitorConfig.SCHEMA_NAME);
    flyway.migrate();
    LOG.info("Initialization of flyway bean has been completed in FlywayConfig.");
    return flyway;
  }
}
