## 1. JEP 356: Enhanced Pseudo-Random Number Generators

Introdução de novas interfaces e implementações para geradores de números pseudo-aleatórios (PRNGs), oferecendo maior flexibilidade e suporte a novos algoritmos como LXM.

## 2. JEP 382: New macOS Rendering Pipeline

Implementação de um novo pipeline de renderização para macOS, utilizando a API Apple Metal. Isso melhora o desempenho gráfico e a compatibilidade com as versões mais recentes do macOS.

## 3. JEP 391: macOS/AArch64 Port

Portabilidade do JDK para a arquitetura AArch64 no macOS, permitindo que o Java 17 seja executado nativamente em Macs com chips Apple Silicon (como M1, M1 Pro, M1 Max).

## 4. JEP 403: Strongly Encapsulate JDK Internals

Encapsulamento forte de APIs internas do JDK, com poucas exceções. Essa mudança melhora a segurança e a manutenção, impedindo o uso de APIs internas não documentadas e potencialmente inseguras.

## 5. JEP 406: Pattern Matching for switch (Preview)

Introdução de correspondência de padrões (Pattern Matching) para instruções switch, permitindo uma maneira mais flexível e concisa de executar lógica condicional baseada no tipo de objeto.

## 6. JEP 409: Sealed Classes

As classes seladas (Sealed Classes) permitem que uma classe ou interface restrinja quais outras classes ou interfaces podem estendê-la ou implementá-la. Isso é útil para modelar hierarquias de classes mais seguras e controladas.

## 7. JEP 410: Remove the Experimental AOT and JIT Compiler

Remoção dos compiladores AOT (Ahead-Of-Time) e JIT (Just-In-Time) experimentais, que estavam sendo desenvolvidos como uma alternativa, mas que tiveram baixa adoção e complexidade de manutenção.

## 8. JEP 411: Deprecate the Security Manager for Removal

O Security Manager, um mecanismo de segurança usado para definir permissões em aplicativos Java, foi depreciado para remoção em futuras versões. O Security Manager não é mais considerado uma maneira eficaz de garantir a segurança de aplicações Java modernas.

## 9. JEP 412: Foreign Function & Memory API (Incubator)

Introdução de uma API para permitir que programas Java interoperem com código e dados fora da JVM (como bibliotecas nativas e memória não gerenciada). Esta é uma API de incubação, significando que ainda está em fase experimental.

## 10. JEP 414: Vector API (Second Incubator)

Segunda iteração da API de vetores, que permite computação vetorial de alto desempenho na JVM, permitindo que operações paralelas sejam executadas em um único passo para melhorar o desempenho.

## 11. JEP 415: Context-Specific Deserialization Filters

Introdução de filtros de desserialização específicos para o contexto, melhorando a segurança ao permitir que desenvolvedores definam políticas de filtragem específicas para objetos que estão sendo desserializados, mitigando riscos de segurança associados à desserialização de dados potencialmente maliciosos.