/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview.web;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import cloud.itknowledge.hu.bvinterview.model.InsertsMonitoredEntity;
import cloud.itknowledge.hu.bvinterview.service.InsertsMonitoredService;

/**
 * @author Zoltán.Katona
 *
 */
@Controller
public class WebSocketController {

  private static final Logger LOG = LoggerFactory.getLogger(WebSocketController.class);

  private static long idCounter = 0;

  @Autowired
  private InsertsMonitoredService srv;

  @Autowired
  private SimpMessagingTemplate template;
  
  @Scheduled(fixedDelay = 1000)
  public void autoSendWebSocketMsg() throws Exception {
    long actualId = srv.getMaxId();
    LOG.info("- autoSendWebSocketMsg() idCounter {} and actualId {}", idCounter, actualId);
    if (idCounter < actualId) {
      List<InsertsMonitoredEntity> list = srv.getGreatherThan(idCounter);
      idCounter = actualId;
      list.stream().map(im -> {
        template.convertAndSend("/topic/dbmonitor-websocket", im.toString());
        return im;
      }).collect(Collectors.toList());
      
    }
  }
}
