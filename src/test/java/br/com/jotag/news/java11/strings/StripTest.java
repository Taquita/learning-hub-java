package br.com.jotag.news.java11.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Esta classe demonstra a diferença entre remover espaços em branco de uma string
 * usando a abordagem tradicional (trim) e a abordagem moderna introduzida no Java 11
 * com os metodos strip(), stripLeading() e stripTrailing().
 */
public class StripTest {

  /**
   * O metodo trim() remove espaços em branco apenas do início e do fim da string.
   * No entanto, ele considera apenas os espaços tradicionais (U+0020).
   */
  @Test
  void testTrim() {
    String text = "   Java 11  ";
    String trimmed = text.trim();

    assertEquals("Java 11", trimmed, "trim() remove os espaços tradicionais do início e do fim da string");
  }

  /**
   * O metodo strip(), introduzido no Java 11, remove espaços em branco do início e do fim
   * da string de acordo com a definição do Unicode, o que inclui uma gama mais ampla de caracteres.
   */
  @Test
  void testStrip() {
    String text = "\u2002  Java 11  "; // \u2002 e um espaço em branco do Unicode
    String stripped = text.strip();

    assertEquals("Java 11", stripped, "strip() remove espaços em branco de todo tipo, conforme definido pelo Unicode");
  }

  /**
   * O metodo stripLeading() remove os espaços em branco apenas do início da string,
   * deixando os espaços no final intactos.
   */
  @Test
  void testStripLeading() {
    String text = "   Java 11  ";
    String strippedLeading = text.stripLeading();

    assertEquals("Java 11  ", strippedLeading, "stripLeading() remove apenas os espaços em branco do início");
  }

  /**
   * O metodo stripTrailing() remove os espaços em branco apenas do final da string,
   * deixando os espaços no início intactos.
   */
  @Test
  void testStripTrailing() {
    String text = "   Java 11  ";
    String strippedTrailing = text.stripTrailing();

    assertEquals("   Java 11", strippedTrailing, "stripTrailing() remove apenas os espaços em branco do final");
  }

  /**
   * Comparação entre trim() e strip():
   *
   * 1. trim() remove apenas espaços tradicionais (U+0020).
   * 2. strip() remove todos os espaços em branco definidos pelo Unicode.
   */
  @Test
  void testTrimVsStrip() {
    String text = "\u2002  Java 11  "; // \u2002 e um espaço em branco do Unicode
    String trimmed = text.trim();
    String stripped = text.strip();

    assertNotEquals(trimmed, stripped, "strip() remove espaços que trim() não remove");
    assertEquals("Java 11", stripped, "strip() e mais completo e eficiente ao lidar com espaços em branco conforme o padrão Unicode.");
  }
  
}
