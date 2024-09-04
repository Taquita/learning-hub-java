package br.com.jotag.news.java11.collections;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ImmutableSetTest {

  @Test
  void testCreateImmutableSet() {
    Set<String> fruits = Set.of("Apple", "Banana", "Cherry");

    assertEquals(3, fruits.size());
    assertThrows(UnsupportedOperationException.class, () -> fruits.add("Orange"));
  }

  @Test
  void testImmutableSetNoDuplicates() {
    assertThrows(IllegalArgumentException.class, () -> Set.of("Apple", "Banana", "Apple"));
  }
}
