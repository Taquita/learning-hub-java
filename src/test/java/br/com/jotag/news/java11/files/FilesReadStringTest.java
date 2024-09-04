package br.com.jotag.news.java11.files;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilesReadStringTest {

  private static final Path FILE_PATH = Paths.get("example_read.txt");

  @Test
  void testReadStringFromFile() throws IOException {
    String content = "Hello, Java 11! This is a test.";
    Files.writeString(FILE_PATH, content);

    String readContent = Files.readString(FILE_PATH);
    assertEquals(content, readContent, "O conteúdo lido deve corresponder ao conteúdo escrito");

    Files.deleteIfExists(FILE_PATH);
  }

  @Test
  void testReadStringFromFileWithCharset() throws IOException {
    String content = "Hello, Java 11 with Charset!";
    Files.writeString(FILE_PATH, content, StandardCharsets.UTF_8);

    String readContent = Files.readString(FILE_PATH, StandardCharsets.UTF_8);
    assertEquals(content, readContent, "O conteúdo lido com charset específico deve corresponder ao conteúdo escrito");

    Files.deleteIfExists(FILE_PATH);
  }

  @Test
  void testReadStringNonExistentFile() {
    Path nonExistentPath = Paths.get("non_existent_file.txt");

    assertThrows(IOException.class, () -> {
      Files.readString(nonExistentPath);
    }, "Deve lançar NoSuchFileException ao tentar ler um arquivo inexistente");
  }

}
