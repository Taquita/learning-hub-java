package br.com.jotag.news.java11.strings;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class RepeatPerformanceTest {

  private static final String TEXT = "Java";
  private static final int REPEAT_COUNT = 10000; // Número de repetições para o benchmark

  @Benchmark
  public String testRepeatMethod() {
    return TEXT.repeat(REPEAT_COUNT);
  }

  @Benchmark
  public String testManualLoopStringBuilder() {
    StringBuilder stringBuilder = new StringBuilder(TEXT.length() * REPEAT_COUNT);
    for (int i = 0; i < REPEAT_COUNT; i++) {
      stringBuilder.append(TEXT);
    }
    return stringBuilder.toString();
  }

  @Benchmark
  public String testManualLoop() {
    String result = "";
    for (int i = 0; i < REPEAT_COUNT; i++) {
      result += TEXT;
    }
    return result;
  }

}
