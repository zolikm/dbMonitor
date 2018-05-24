/**
 * Copyright (c) 2018 ITKnowledge.cloud. All Rights Reserved.
 */
package cloud.itknowledge.hu.bvinterview;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import cloud.itknowledge.hu.bvinterview.configuration.DbMonitorTestConfig;
import cloud.itknowledge.hu.bvinterview.configuration.WebSocketConfig;
import cloud.itknowledge.hu.bvinterview.service.InsertsMonitoredService;

/**
 * @author Zoltán.Katona
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DbMonitorApplication.class, WebSocketConfig.class, DbMonitorTestConfig.class}) //(webEnvironment=WebEnvironment.DEFINED_PORT)
@DataJpaTest
public class WebSocketTest {

  static final String WEBSOCKET_URI = "ws://localhost:8080/dbmonitor-websocket";
  static final String WEBSOCKET_TOPIC = "/topic";

  BlockingQueue<String> blockingQueue;
  WebSocketStompClient stompClient;

  @Autowired
  private InsertsMonitoredService insertsMonitoredService;

  @Before
  public void setup() {
    blockingQueue = new LinkedBlockingDeque<>();
    stompClient = new WebSocketStompClient(
        new SockJsClient(Arrays.asList(new WebSocketTransport(new StandardWebSocketClient()))));
  }

  @Ignore
  @Test
  public void shouldReceiveAMessageFromTheServer() throws Exception {
    insertsMonitoredService.insertWidthDescription("WebSocket test msg description.");

    StompSession session = stompClient.connect(
      WEBSOCKET_URI, new StompSessionHandlerAdapter() {}
    ).get(1, TimeUnit.SECONDS);
    session.subscribe(WEBSOCKET_TOPIC, new DefaultStompFrameHandler());

    Assert.assertNotNull(blockingQueue.poll(3, TimeUnit.SECONDS));
  }

  class DefaultStompFrameHandler implements StompFrameHandler {
    @Override
    public Type getPayloadType(StompHeaders stompHeaders) {
      return byte[].class;
    }

    @Override
    public void handleFrame(StompHeaders stompHeaders, Object o) {
      blockingQueue.offer(new String((byte[])o));
    }
  }
}
