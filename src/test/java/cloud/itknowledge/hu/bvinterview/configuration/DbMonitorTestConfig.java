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
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import cloud.itknowledge.hu.bvinterview.configuration.DbMonitorConfig;

/**
 * @author Zoltán.Katona
 *
 */
@Configuration
public class DbMonitorTestConfig {
  private static final Logger LOG = LoggerFactory.getLogger(DbMonitorTestConfig.class);

  @Bean
  public DataSource dataSource() {
    LOG.info("Initializing dataSource bean in H2DbConfig started.");
    DataSource ds = new EmbeddedDatabaseBuilder()
      .setType(EmbeddedDatabaseType.H2)
      .setName(DbMonitorConfig.SCHEMA_NAME)
      .build();
    LOG.info("Initializing dataSource bean in H2DbConfig finished.");
    return ds;
  }

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

//  @Bean
//  public InsertsMonitoredService insertsMonitoredService() {
//    return new InsertsMonitoredServiceImpl();
//  }

}
