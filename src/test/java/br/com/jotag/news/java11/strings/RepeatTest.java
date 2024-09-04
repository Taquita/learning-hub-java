package br.com.jotag.news.java11.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepeatTest {

  @Test
  void testRepeatZeroTimes() {
    String text = "Java";
    String repeated = text.repeat(0);

    assertEquals("", repeated, "Repetindo 0 vezes deve retornar uma string vazia");
  }

  @Test
  void testRepeatOnce() {
    String text = "Java";
    String repeated = text.repeat(1);

    assertEquals("Java", repeated, "Repetindo 1 vez deve retornar a string original");
  }

  @Test
  void testRepeatMultipleTimes() {
    String text = "Java";
    String repeated = text.repeat(3);

    assertEquals("JavaJavaJava", repeated, "Repetindo 3 vezes deve concatenar a string 3 vezes");
  }

  @Test
  void testRepeatNegativeTimes() {
    String text = "Java";

    assertThrows(IllegalArgumentException.class, () -> {
      text.repeat(-1);
    }, "Repetir um número negativo de vezes deve lançar IllegalArgumentException");
  }

}
