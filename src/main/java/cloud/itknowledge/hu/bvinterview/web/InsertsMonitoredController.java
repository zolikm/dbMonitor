/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.itknowledge.hu.bvinterview.model.InsertsMonitoredEntity;
import cloud.itknowledge.hu.bvinterview.service.InsertsMonitoredService;

/**
 * @author Zoltán.Katona
 *
 */
@RestController
public class InsertsMonitoredController {

  @Autowired
  private InsertsMonitoredService service;

  @RequestMapping(method = RequestMethod.GET, path = "/select", 
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public HttpEntity<List<InsertsMonitoredEntity>> select() {
    List<InsertsMonitoredEntity> list = service.getAll();
    return new ResponseEntity<List<InsertsMonitoredEntity>>(list, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/insert/{description}", 
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public HttpEntity<InsertsMonitoredEntity> insert(@PathVariable(name = "description") String desc) {
    InsertsMonitoredEntity res = service.insertWidthDescription(desc);
    return new ResponseEntity<InsertsMonitoredEntity>(res, HttpStatus.OK); // TODO
  }
}
