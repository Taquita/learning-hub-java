package br.com.jotag.news.java11.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Esta classe demonstra a diferença entre verificar se uma string é vazia ou contém
 * apenas espaços em branco usando a abordagem tradicional (antes do Java 11)
 * e a abordagem moderna introduzida no Java 11.
 */
public class IsBlankTest {

  /**
   * Antes do Java 11, para verificar se uma string era vazia ou continha apenas espaços em branco,
   * usávamos a combinação de trim() e isEmpty(). Isso removia os espaços em branco
   * do início e do fim da string e então verificava se a string resultante estava vazia.
   */
  @Test
  void testTrimIsEmpty() {
    String text = "   ";
    boolean isBlankOld = text.trim().isEmpty();

    assertTrue(isBlankOld, "String com apenas espaços retorna true usando trim().isEmpty()");
  }

  /**
   * No Java 11, o metodo isBlank() foi introduzido para simplificar essa verificação.
   * Ele verifica diretamente se a string é vazia ou contém apenas espaços em branco,
   * sem a necessidade de criar uma nova string como no caso de trim().
   */
  @Test
  void testIsBlank() {
    String text = "   ";
    boolean isBlankNew = text.isBlank();

    assertTrue(isBlankNew, "String com apenas espaços retorna true usando isBlank()");
  }

  /**
   * Vantagens do uso de isBlank() sobre trim().isEmpty():
   *
   * 1. Simplicidade: isBlank() é mais direto e legível, eliminando a necessidade de duas chamadas de método.
   * 2. Eficiência: isBlank() pode ser mais eficiente, pois é projetado especificamente para essa verificação,
   *    enquanto trim() cria uma nova string, o que pode ser desnecessário e menos performático em alguns casos.
   */
  @Test
  void testComparison() {
    String text = "   ";
    boolean isBlankOld = text.trim().isEmpty();
    boolean isBlankNew = text.isBlank();

    assertEquals(isBlankOld, isBlankNew, "Ambas as abordagens devem retornar o mesmo resultado");
    assertTrue(isBlankNew, "isBlank() é uma forma mais simples e eficiente de verificar se uma string é vazia ou contém apenas espaços em branco.");
  }
}
