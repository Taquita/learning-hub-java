package br.com.jotag.news.java11.nestbasedaccess;

public class OuterClass {
  private String outerField = "OuterField";

  public class InnerClass {
    private String innerField = "InnerField";

    public String accessOuterField() {
      // Acesso direto ao campo privado da classe externa
      return outerField;
    }
  }

  public String accessInnerField() {
    InnerClass inner = new InnerClass();
    // Acesso direto ao campo privado da classe interna
    return inner.innerField;
  }
}
