package br.com.jotag.news.java11.httpclient;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

public class HttpClientAuthTest {

  private static MockWebServer mockWebServer;

  @BeforeAll
  static void setUp() throws Exception {
    mockWebServer = new MockWebServer();
    mockWebServer.start();
  }

  @AfterAll
  static void tearDown() throws Exception {
    mockWebServer.shutdown();
  }

  @Test
  void testBasicAuthentication() throws Exception {
    // Simula uma resposta que requer autenticação básica
    mockWebServer.enqueue(new MockResponse()
        .addHeader("WWW-Authenticate", "Basic realm=\"Access to the site\"")
        .setResponseCode(401)); // Responde com 401 Unauthorized inicialmente

    mockWebServer.enqueue(new MockResponse()
        .setResponseCode(200)
        .setBody("Authenticated!")); // Após a autenticação, retorna 200 OK

    // Configura o HttpClient com autenticação básica
    HttpClient client = HttpClient.newBuilder()
        .authenticator(new Authenticator() {
          @Override
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("user", "password".toCharArray());
          }
        })
        .build();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(mockWebServer.url("/auth").toString()))
        .GET()
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    assertEquals(200, response.statusCode());
    assertEquals("Authenticated!", response.body());
  }


}
