package br.com.jotag.news.java11.collections;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ImmutableListTest {

  @Test
  void testCreateImmutableList() {
    List<String> fruits = List.of("Apple", "Banana", "Cherry");

    assertEquals(3, fruits.size());
    assertEquals("Apple", fruits.get(0));
  }

  @Test
  void testImmutableListModification() {
    List<String> fruits = List.of("Apple", "Banana", "Cherry");

    assertThrows(UnsupportedOperationException.class, () -> fruits.add("Orange"));
    assertThrows(UnsupportedOperationException.class, () -> fruits.remove("Banana"));
  }

  @Test
  void testImmutableEmptyList() {
    List<String> emptyList = List.of();

    assertEquals(0, emptyList.size());
    assertEquals(Collections.emptyList(), emptyList);
  }
}
