/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cloud.itknowledge.hu.bvinterview.model.InsertsMonitoredEntity;

/**
 * @author Zoltán.Katona
 *
 */
@Repository
public interface InsertsMonitoredRepository extends CrudRepository<InsertsMonitoredEntity, Long> {

  List<InsertsMonitoredEntity> findAll();

  @Query("select max(im.id) from InsertsMonitoredEntity im")
  Long searchMaxId();

  @Query("select im from InsertsMonitoredEntity im where im.id > :compareId ")
  List<InsertsMonitoredEntity> findGreatherThan(@Param("compareId") Long compareId);
}
