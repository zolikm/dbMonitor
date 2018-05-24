/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import cloud.itknowledge.hu.bvinterview.model.InsertsMonitoredEntity;
import cloud.itknowledge.hu.bvinterview.repository.InsertsMonitoredRepository;
import cloud.itknowledge.hu.bvinterview.service.InsertsMonitoredService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DbMonitorReadWriteTest {

  private static final String TEST_MESSAGE = "Test insert message.";

  @Autowired
  private InsertsMonitoredRepository insertsMonitoredRepositroy;

  @Autowired
  private InsertsMonitoredService insertsMonitoredService;

  @Test
  public void contextLoadsTest() {
    assertNotNull(insertsMonitoredRepositroy);
    assertNotNull(insertsMonitoredService);
  }

  @Test
  public void insertTest() {
    insertsMonitoredService.insertWidthDescription(TEST_MESSAGE);
    List<InsertsMonitoredEntity> list = insertsMonitoredService.getAll();
    assertNotNull(list);
    assertEquals(2, list.size());
    assertEquals(TEST_MESSAGE, list.get(1).getDescription());
  }
}
