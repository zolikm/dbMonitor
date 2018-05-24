/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.itknowledge.hu.bvinterview.model.InsertsMonitoredEntity;
import cloud.itknowledge.hu.bvinterview.repository.InsertsMonitoredRepository;

/**
 * @author Zoltán.Katona
 *
 */
@Service
public class InsertsMonitoredServiceImpl implements InsertsMonitoredService {

  @Autowired
  private InsertsMonitoredRepository repo;

  public InsertsMonitoredServiceImpl() {
    super();
  }

  /**
   * @param repo
   */
  public InsertsMonitoredServiceImpl(InsertsMonitoredRepository repo) {
    super();
    this.repo = repo;
  }

  /* (non-Javadoc)
   * @see cloud.itknowledge.hu.bvinterview.service.InsertsMonitoredService#getAll()
   */
  @Override
  public List<InsertsMonitoredEntity> getAll() {
    return repo.findAll();
  }

  /* (non-Javadoc)
   * @see cloud.itknowledge.hu.bvinterview.service.InsertsMonitoredService#insertWidthDescription(java.lang.String)
   */
  @Override
  public InsertsMonitoredEntity insertWidthDescription(String description) {
    InsertsMonitoredEntity entity = new InsertsMonitoredEntity();
    entity.setDescription(description);
    return repo.save(entity);
  }

  /* (non-Javadoc)
   * @see cloud.itknowledge.hu.bvinterview.service.InsertsMonitoredService#getMaxId()
   */
  @Override
  public Long getMaxId() {
    return repo.searchMaxId();
  }

  /* (non-Javadoc)
   * @see cloud.itknowledge.hu.bvinterview.service.InsertsMonitoredService#getGreatherThan(java.lang.Long)
   */
  @Override
  public List<InsertsMonitoredEntity> getGreatherThan(Long compareId) {
    return repo.findGreatherThan(compareId);
  }
}
