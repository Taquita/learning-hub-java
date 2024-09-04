package br.com.jotag.news.java11.streams;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredicateNotTest {

  @Test
  void testFilterNonEmptyStrings() {
    List<String> strings = Stream.of("apple", "", "banana", "cherry", "")
        .filter(Predicate.not(String::isEmpty))
        .collect(Collectors.toList());

    assertEquals(List.of("apple", "banana", "cherry"), strings);
  }

  @Test
  void testFilterEvenNumbers() {
    List<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6)
        .filter(Predicate.not(n -> n % 2 != 0))
        .collect(Collectors.toList());

    assertEquals(List.of(2, 4, 6), numbers);
  }

  @Test
  void testFilterStringsStartingWithA() {
    List<String> strings = Stream.of("apple", "banana", "avocado", "berry", "apricot")
        .filter(Predicate.not(s -> s.startsWith("a")))
        .collect(Collectors.toList());

    assertEquals(List.of("banana", "berry"), strings);
  }

  @Test
  void testFilterOddNumbers() {
    List<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6)
        .filter(Predicate.not(n -> n % 2 == 0))
        .collect(Collectors.toList());

    assertEquals(List.of(1, 3, 5), numbers);
  }
}
