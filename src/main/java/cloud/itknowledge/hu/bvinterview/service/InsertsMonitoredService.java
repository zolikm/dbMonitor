/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview.service;

import java.util.List;

import cloud.itknowledge.hu.bvinterview.model.InsertsMonitoredEntity;

/**
 * @author Zoltán.Katona
 *
 */
public interface InsertsMonitoredService {

  List<InsertsMonitoredEntity> getAll();

  InsertsMonitoredEntity insertWidthDescription(String description);

  Long getMaxId();

  List<InsertsMonitoredEntity> getGreatherThan(Long compareId);

}
