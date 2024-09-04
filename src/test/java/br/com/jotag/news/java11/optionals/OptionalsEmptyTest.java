package br.com.jotag.news.java11.optionals;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalsEmptyTest {

  @Test
  void testOptionalIsEmptyWhenEmpty() {
    Optional<String> emptyOptional = Optional.empty();

    assertTrue(emptyOptional.isEmpty(), "Optional.isEmpty() deve retornar true para um Optional vazio");
  }

  @Test
  void testOptionalIsEmptyWhenPresent() {
    Optional<String> optionalWithValue = Optional.of("Java");

    assertFalse(optionalWithValue.isEmpty(), "Optional.isEmpty() deve retornar false para um Optional com valor");
  }

  @Test
  void testOptionalIsEmptyVsIsPresent() {
    Optional<String> emptyOptional = Optional.empty();

    assertEquals(emptyOptional.isEmpty(), !emptyOptional.isPresent(), "isEmpty() e !isPresent() devem retornar o mesmo resultado para um Optional vazio");
  }

}
