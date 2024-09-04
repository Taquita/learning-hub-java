package br.com.jotag.news.java11.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropWhileTest {

  @Test
  void testDropWhileLessThanFive() {
    List<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7)
        .dropWhile(n -> n < 5)
        .collect(Collectors.toList());

    assertEquals(List.of(5, 6, 7), numbers);
  }

  @Test
  void testDropWhileEmptyStream() {
    List<Integer> numbers = Stream.of(1, 2, 3)
        .dropWhile(n -> n < 5)
        .collect(Collectors.toList());

    assertEquals(List.of(), numbers);
  }

  @Test
  void testDropWhileNoneMatch() {
    List<Integer> numbers = Stream.of(5, 6, 7)
        .dropWhile(n -> n < 5)
        .collect(Collectors.toList());

    assertEquals(List.of(5, 6, 7), numbers);
  }
}
