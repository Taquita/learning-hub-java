package br.com.jotag.news.java11.httpclient;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

public class HttpClientSyncTest {

  private static final String BASE_URI = "https://jsonplaceholder.typicode.com/posts/1";

  @Test
  void testHttpGetSuccess() throws IOException, InterruptedException {
    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URI))
        .GET()
        .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    assertEquals(200, response.statusCode(), "O status da resposta deve ser 200 OK");
    assertNotNull(response.body(), "O corpo da resposta não deve ser nulo");
    assertTrue(response.body().contains("\"id\": 1"), "O corpo da resposta deve conter o ID 1");
  }

  @Test
  void testHttpGetNotFound() throws IOException, InterruptedException {
    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://jsonplaceholder.typicode.com/posts/9999"))
        .GET()
        .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    assertEquals(404, response.statusCode(), "O status da resposta deve ser 404 Not Found");
  }

  @Test
  void testHttpRequestWithInvalidUri() {
    HttpClient httpClient = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://invalid-uri"))
        .GET()
        .build();

    assertThrows(IOException.class, () -> {
      httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }, "Deve lançar IOException para uma URI inválida");
  }

}
