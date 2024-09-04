package br.com.jotag.news.java11.collections;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ImmutableMapTest {

  @Test
  void testCreateImmutableMap() {
    Map<String, Integer> fruitsCount = Map.of("Apple", 1, "Banana", 2, "Cherry", 3);

    assertEquals(3, fruitsCount.size());
    assertEquals(1, fruitsCount.get("Apple"));
  }

  @Test
  void testImmutableMapModification() {
    Map<String, Integer> fruitsCount = Map.of("Apple", 1, "Banana", 2, "Cherry", 3);

    assertThrows(UnsupportedOperationException.class, () -> fruitsCount.put("Orange", 4));
  }

  @Test
  void testImmutableMapDuplicateKeys() {
    assertThrows(IllegalArgumentException.class, () -> Map.of("Apple", 1, "Banana", 2, "Apple", 3));
  }
}
