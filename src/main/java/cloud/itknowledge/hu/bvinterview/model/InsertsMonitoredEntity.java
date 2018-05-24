/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cloud.itknowledge.hu.bvinterview.configuration.DbMonitorConfig;

/**
 * @author Zoltán.Katona
 *
 */
@Entity
@Table(schema = DbMonitorConfig.SCHEMA_NAME, name = "inserts_monitored")
public class InsertsMonitoredEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;

  @Column(name = "last_mod")
  private LocalDateTime lastMod;

  /**
   * 
   */
  public InsertsMonitoredEntity() {
    super();
    lastMod = LocalDateTime.now();
  }

  /**
   * @param id
   * @param description
   * @param lastMod
   */
  public InsertsMonitoredEntity(Long id, String description, LocalDateTime lastMod) {
    this();
    this.id = id;
    this.description = description;
    this.lastMod = lastMod;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDateTime getLastMod() {
    return lastMod;
  }

  public void setLastMod(LocalDateTime lastMod) {
    this.lastMod = lastMod;
  }

  @Override
  public String toString() {
    return "InsertsMonitorEntity [id=" + id + ", description=" + description + ", lastMod=" + lastMod + "]";
  }

}
