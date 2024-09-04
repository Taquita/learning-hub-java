package br.com.jotag.news.java11.strings;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinesTest {

  @Test
  void testLinesWithNewline() {
    String text = "Java 11\nis\nawesome!";
    List<String> lines = text.lines().collect(Collectors.toList());

    assertEquals(3, lines.size(), "A string deve ser dividida em 3 linhas");
    assertEquals("Java 11", lines.get(0));
    assertEquals("is", lines.get(1));
    assertEquals("awesome!", lines.get(2));
  }

  @Test
  void testLinesWithDifferentLineTerminators() {
    String text = "Java 11\r\nis\rawesome!";
    List<String> lines = text.lines().collect(Collectors.toList());

    assertEquals(3, lines.size(), "A string deve ser dividida em 3 linhas, independentemente do delimitador de linha");
    assertEquals("Java 11", lines.get(0));
    assertEquals("is", lines.get(1));
    assertEquals("awesome!", lines.get(2));
  }

  @Test
  void testLinesIgnoresTrailingEmptyLine() {
    String text = "Java 11\nis\nawesome!\n";
    List<String> lines = text.lines().collect(Collectors.toList());

    assertEquals(3, lines.size(), "A linha vazia no final deve ser ignorada");
    assertEquals("Java 11", lines.get(0));
    assertEquals("is", lines.get(1));
    assertEquals("awesome!", lines.get(2));
  }

  @Test
  void testLinesWithoutLineTerminators() {
    String text = "Java 11 is awesome!";
    List<String> lines = text.lines().collect(Collectors.toList());

    assertEquals(1, lines.size(), "A string sem delimitadores de linha deve ser considerada como uma única linha");
    assertEquals("Java 11 is awesome!", lines.get(0));
  }

}
