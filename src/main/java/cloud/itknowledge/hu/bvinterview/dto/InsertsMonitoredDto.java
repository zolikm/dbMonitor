/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview.dto;

import java.time.LocalDateTime;

/**
 * @author Zoltán.Katona
 *
 */
public class InsertsMonitoredDto {

  private long id;
  private String description;
  private LocalDateTime lastMod;

  /**
   * 
   */
  public InsertsMonitoredDto() {
    super();
  }

  /**
   * @param id
   * @param description
   * @param lastMod
   */
  public InsertsMonitoredDto(long id, String description, LocalDateTime lastMod) {
    super();
    this.id = id;
    this.description = description;
    this.lastMod = lastMod;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
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
    return "InsertsMonitoredDto [id=" + id + ", description=" + description + ", lastMod=" + lastMod + "]";
  }

}
