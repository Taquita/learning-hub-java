package br.com.jotag.news.java11.httpclient;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class WebSocketClientTest {

  private static final String ECHO_URI = "wss://echo.websocket.org";

  @Test
  void testWebSocketEcho() throws InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    CountDownLatch latch = new CountDownLatch(1);

    WebSocket webSocket = client.newWebSocketBuilder()
        .buildAsync(URI.create(ECHO_URI), new EchoWebSocketListener(latch))
        .join();

    webSocket.sendText("Hello WebSocket!", true);

    assertTrue(latch.await(10, TimeUnit.SECONDS), "A mensagem de eco deve ser recebida dentro do tempo limite");

    webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "Test complete");
  }

  private static class EchoWebSocketListener implements Listener {

    private final CountDownLatch latch;
    private boolean firstMessageReceived = false;

    EchoWebSocketListener(CountDownLatch latch) {
      this.latch = latch;
    }

    @Override
    public void onOpen(WebSocket webSocket) {
      System.out.println("Conexão aberta");
      Listener.super.onOpen(webSocket);
    }

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
      if (!firstMessageReceived) {
        firstMessageReceived = true;
        System.out.println("Mensagem inicial recebida e ignorada: " + data);
        return Listener.super.onText(webSocket, data, last);
      }

      System.out.println("Mensagem recebida: " + data);
      assertTrue(data.toString().contains("Hello WebSocket!"), "A mensagem de eco deve conter o texto enviado");
      latch.countDown(); // Libera a espera quando a mensagem de eco é recebida
      return Listener.super.onText(webSocket, data, last);
    }

    @Override
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
      System.out.println("Conexão fechada com código: " + statusCode + ", razão: " + reason);
      return Listener.super.onClose(webSocket, statusCode, reason);
    }

    @Override
    public void onError(WebSocket webSocket, Throwable error) {
      fail("Erro no WebSocket: " + error.getMessage());
    }
  }
}
