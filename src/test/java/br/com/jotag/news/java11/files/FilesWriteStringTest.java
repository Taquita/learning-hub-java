package br.com.jotag.news.java11.files;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilesWriteStringTest {

  private static final Path FILE_PATH = Paths.get("example.txt");

  @Test
  void testWriteStringToFile() throws IOException {
    String content = "Hello, Java 11!";
    Files.writeString(FILE_PATH, content);

    String readContent = Files.readString(FILE_PATH);
    assertEquals(content, readContent, "O conteúdo do arquivo deve corresponder à string escrita");

    Files.deleteIfExists(FILE_PATH);
  }

  @Test
  void testWriteStringAppendToFile() throws IOException {
    String initialContent = "Hello, Java 11!";
    Files.writeString(FILE_PATH, initialContent);

    String additionalContent = "\nThis is an appended line.";
    Files.writeString(FILE_PATH, additionalContent, StandardOpenOption.APPEND);

    String readContent = Files.readString(FILE_PATH);
    assertEquals(initialContent + additionalContent, readContent, "O conteúdo do arquivo deve incluir a linha adicionada");

    Files.deleteIfExists(FILE_PATH);
  }

  @Test
  void testWriteStringCreatesNewFile() throws IOException {
    Path newFilePath = Paths.get("new_example.txt");
    String content = "New File Content";
    Files.writeString(newFilePath, content);

    assertTrue(Files.exists(newFilePath), "O arquivo deve ser criado se não existir");

    Files.deleteIfExists(newFilePath);
  }


}
