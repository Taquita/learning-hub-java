# Learning Hub - Java Benchmarks

Este projeto contém uma coleção de benchmarks projetados para avaliar o desempenho de diferentes métodos e funcionalidades em diversas versões do Java. O objetivo é fornecer uma base para medir a performance de várias operações que podem ser críticas em sistemas de alta performance.

## Como Rodar os Benchmarks

### 1. Compilação e Empacotamento

Para compilar e empacotar o projeto, utilize o Maven:

```bash
mvn clean package
```

Este comando gerará um JAR sombreado (shaded JAR) na pasta target, incluindo todas as dependências necessárias para rodar os benchmarks.

### 2. Executando os Benchmarks:

Para rodar qualquer benchmark do projeto, utilize o comando abaixo, substituindo NomeDaClasseDeBenchmark pela classe de benchmark desejada:

```bash
java -jar target/learning-hub-1.0-SNAPSHOT.jar ReferenciaDaClasseDeBenchmark
```

Exemplo:

```bash
java -jar target/learning-hub-1.0-SNAPSHOT.jar br.com.jotag.news.java11.strings.IsBlankPerformanceTest
```

### 3. Interpretação dos Resultados:

Após executar o comando, o JMH exibirá os resultados diretamente no console. Os resultados incluem:

- Score: O tempo médio por operação, geralmente em nanossegundos (ns/op).
- Error: A margem de erro estatística do benchmark.
- Units: As unidades de medição utilizadas, como nanossegundos por operação (ns/op).
