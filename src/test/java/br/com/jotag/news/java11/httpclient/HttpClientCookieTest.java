package br.com.jotag.news.java11.httpclient;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.MockResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HttpClientCookieTest {

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
  void testCookieHandling() throws Exception {
    mockWebServer.enqueue(new MockResponse()
        .addHeader("Set-Cookie", "session_id=12345; Path=/; HttpOnly")
        .setResponseCode(200)
        .setBody("Cookie Set"));

    CookieManager cookieManager = new CookieManager();
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

    HttpClient client = HttpClient.newBuilder()
        .cookieHandler(cookieManager)
        .build();

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(mockWebServer.url("/cookie").toString()))
        .GET()
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    assertEquals(200, response.statusCode());
    assertEquals("Cookie Set", response.body());

    CookieStore cookieStore = cookieManager.getCookieStore();
    List<HttpCookie> cookies = cookieStore.getCookies();
    assertTrue(cookies.stream().anyMatch(cookie -> cookie.getName().equals("session_id") && cookie.getValue().equals("12345")));
  }
}
