package br.com.jotag.news.java11.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TakeWhileTest {

  @Test
  void testTakeWhileLessThanFive() {
    List<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7)
        .takeWhile(n -> n < 5)
        .collect(Collectors.toList());

    assertEquals(List.of(1, 2, 3, 4), numbers);
  }

  @Test
  void testTakeWhileEmptyStream() {
    List<Integer> numbers = Stream.of(6, 7, 8)
        .takeWhile(n -> n < 5)
        .collect(Collectors.toList());

    assertEquals(List.of(), numbers);
  }

  @Test
  void testTakeWhileAllMatch() {
    List<Integer> numbers = Stream.of(1, 2, 3, 4)
        .takeWhile(n -> n < 5)
        .collect(Collectors.toList());

    assertEquals(List.of(1, 2, 3, 4), numbers);
  }
}
