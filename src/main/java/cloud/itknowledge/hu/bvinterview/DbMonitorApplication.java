/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(value = { "cloud.itknowledge.hu.bvinterview" })
@SpringBootApplication
@EnableJpaRepositories(basePackages = "cloud.itknowledge.hu.bvinterview.repository")
@EnableScheduling
public class DbMonitorApplication {

  public static void main(String[] args) {
    SpringApplication.run(DbMonitorApplication.class, args);
  }

}
