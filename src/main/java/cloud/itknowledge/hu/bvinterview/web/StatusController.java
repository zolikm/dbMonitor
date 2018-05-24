/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zoltán.Katona
 *
 */
@RestController
public class StatusController {

  @Value("${app.version:unknown}")
  private String version;

  @RequestMapping(method = RequestMethod.GET, path = "/health", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public HttpEntity<String> health() {
    return new HttpEntity<String>("Ok");
  }

  @RequestMapping(method = RequestMethod.GET, path = "/info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public HttpEntity<String> info() {
    return new HttpEntity<String>("version: " + version);
  }

}
