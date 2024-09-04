package br.com.jotag.news.java11.httpclient;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class HttpClientAsyncTest {

  private static final String BASE_URI = "https://jsonplaceholder.typicode.com/posts/1";

  @Test
  void testHttpGetAsyncSuccess() throws ExecutionException, InterruptedException {
    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URI))
        .GET()
        .build();

    CompletableFuture<HttpResponse<String>> futureResponse =
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

    HttpResponse<String> response = futureResponse.get();

    assertEquals(200, response.statusCode(), "O status da resposta deve ser 200 OK");
    assertNotNull(response.body(), "O corpo da resposta não deve ser nulo");
    assertTrue(response.body().contains("\"id\": 1"), "O corpo da resposta deve conter o ID 1");
  }

  @Test
  void testHttpGetAsyncNotFound() throws ExecutionException, InterruptedException {
    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://jsonplaceholder.typicode.com/posts/9999"))
        .GET()
        .build();

    CompletableFuture<HttpResponse<String>> futureResponse =
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

    HttpResponse<String> response = futureResponse.get();

    assertEquals(404, response.statusCode(), "O status da resposta deve ser 404 Not Found");
  }

  @Test
  void testHttpRequestAsyncWithInvalidUri() {
    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://invalid-uri"))
        .GET()
        .build();

    CompletableFuture<HttpResponse<String>> futureResponse =
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

    ExecutionException executionException = assertThrows(ExecutionException.class, () -> {
      futureResponse.get();
    }, "Deve lançar ExecutionException para uma URI inválida");

    assertTrue(executionException.getCause() instanceof IOException, "A causa deve ser IOException para uma URI inválida");
  }

  @Test
  void testHttpGetAsyncWithCallback() throws InterruptedException {
    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URI))
        .GET()
        .build();

    CountDownLatch latch = new CountDownLatch(1);

    CompletableFuture<HttpResponse<String>> futureResponse =
        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

    futureResponse.thenAccept(response -> {
      assertEquals(200, response.statusCode(), "O status da resposta deve ser 200 OK");
      assertNotNull(response.body(), "O corpo da resposta não deve ser nulo");
      assertTrue(response.body().contains("\"id\": 1"), "O corpo da resposta deve conter o ID 1");
      latch.countDown();
    });

    assertTrue(latch.await(5, TimeUnit.SECONDS), "Callback não foi chamado dentro do tempo esperado");
  }
}
