package br.com.jotag.news.java11.nestbasedaccess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NestBasedAccessControlTest {

  @Test
  void testInnerClassAccessPrivateOuterField() {
    OuterClass outer = new OuterClass();
    OuterClass.InnerClass inner = outer.new InnerClass();

    // Acesso direto ao campo privado da classe externa
    assertEquals("OuterField", inner.accessOuterField());
  }

  @Test
  void testOuterClassAccessPrivateInnerField() {
    OuterClass outer = new OuterClass();

    // Acesso direto ao campo privado da classe interna
    assertEquals("InnerField", outer.accessInnerField());
  }

  @Test
  void testDirectAccessThrowsException() {
    OuterClass outer = new OuterClass();
    OuterClass.InnerClass inner = outer.new InnerClass();

    // Tentar acessar diretamente os campos privados de fora da classe aninhada deve causar um erro
    assertThrows(NoSuchFieldException.class, () -> {
      outer.getClass().getDeclaredField("innerField").setAccessible(true);
    });
  }
}
