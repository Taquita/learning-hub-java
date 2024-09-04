package br.com.jotag.news.java11.strings;

public class IsBlankTest {
  
  @Test
  void testIsBlank() {
    String empty = "";
    String spaces = "   ";
    String text = "Java 11";

    // Verifica se a string vazia retorna true
    assertTrue(empty.isBlank(), "String vazia deve retornar true para isBlank()");

    // Verifica se a string com espaços em branco retorna true
    assertTrue(spaces.isBlank(), "String com apenas espaços deve retornar true para isBlank()");

    // Verifica se a string com texto retorna false
    assertFalse(text.isBlank(), "String com texto deve retornar false para isBlank()");
  }
}
