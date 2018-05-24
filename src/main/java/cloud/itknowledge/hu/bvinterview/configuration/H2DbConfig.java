/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * H2 in memory database configuration.<br>
 * Web console reacheable: {@link http://localhost:8082}
 * <ul>
 * <li>user name: sa</li>
 * <li>password: [empty]</li>
 * <li>url: localhost:8082</li>
 * <li>driver class: org.h2.Driver</li>
 * <li>jdbc url: jdbc:h2:mem:itknowledge</li>
 * </ul
 * @author Zoltán.Katona
 *
 */
@Configuration
public class H2DbConfig {

  private static final Logger LOG = LoggerFactory.getLogger(H2DbConfig.class);

  @Bean(destroyMethod = "shutdown")
  public DataSource dataSource() {
    LOG.info("Initializing dataSource bean in H2DbConfig started.");
    DataSource ds = new EmbeddedDatabaseBuilder()
      .setType(EmbeddedDatabaseType.H2)
      .setName(DbMonitorConfig.SCHEMA_NAME)
      .build();
    LOG.info("Initializing dataSource bean in H2DbConfig finished.");
    return ds;
  }

  @Profile("dev")
  @Bean(name = "h2WebServer", initMethod = "start", destroyMethod = "stop")
  public Server createWebServer() throws SQLException {
    return Server.createWebServer("-web", "-webAllowOthers", "-webDaemon", "-webPort", "8082");
  }
}
