package br.com.jotag.news.java11.strings;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class IsBlankPerformanceTest {
  private static final String SPACES = "   ";
  private static final String TEXT = "Java 11";

  @Benchmark
  public boolean measureTrimIsEmpty() {
    return SPACES.trim().isEmpty();
  }

  @Benchmark
  public boolean measureIsBlank() {
    return SPACES.isBlank();
  }

  @Benchmark
  public boolean measureTrimIsEmptyWithText() {
    return TEXT.trim().isEmpty();
  }

  @Benchmark
  public boolean measureIsBlankWithText() {
    return TEXT.isBlank();
  }

}
