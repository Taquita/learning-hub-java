package br.com.jotag.news.java11.optionals;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalsOrElseThrowTest {

  @Test
  void testOrElseThrowWhenPresent() {
    Optional<String> optionalWithValue = Optional.of("Java");

    assertDoesNotThrow(() -> {
      String result = optionalWithValue.orElseThrow();
      assertEquals("Java", result, "O valor presente deve ser retornado sem lançar exceção");
    });
  }

  @Test
  void testOrElseThrowWhenEmpty() {
    Optional<String> emptyOptional = Optional.empty();

    assertThrows(NoSuchElementException.class, () -> {
      emptyOptional.orElseThrow();
    }, "Deve lançar NoSuchElementException quando o Optional está vazio");
  }

  @Test
  void testOrElseThrowVsOrElseThrowSupplier() {
    Optional<String> emptyOptional = Optional.empty();

    assertThrows(NoSuchElementException.class, () -> {
      emptyOptional.orElseThrow();
    }, "orElseThrow() deve lançar NoSuchElementException para um Optional vazio");

    assertThrows(NoSuchElementException.class, () -> {
      emptyOptional.orElseThrow(NoSuchElementException::new);
    }, "orElseThrow(Supplier) deve lançar NoSuchElementException para um Optional vazio");
  }

}
