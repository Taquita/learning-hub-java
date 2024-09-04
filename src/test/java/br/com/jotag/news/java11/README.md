# 1. Melhorias na API de Strings
- isBlank(): Verificar se uma string é vazia ou contém apenas espaços em branco.
- strip(), stripLeading(), stripTrailing(): Remoção de espaços em branco de uma string de forma mais eficiente.
- repeat(int count): Repetir uma string um número específico de vezes.
- lines(): Converter uma string em um stream de linhas.
# 2. Novidades no Optional
- Optional.isEmpty(): Verificar se o Optional está vazio de uma forma mais legível.
- Optional.orElseThrow(): Simplificação para lançar exceções quando o valor não está presente.
# 3. Novidades na API de Arquivos (NIO)
- Files.writeString(): Escrever strings diretamente em um arquivo de forma mais simples.
- Files.readString(): Ler o conteúdo de um arquivo como uma string.
# 4. HTTP Client (Nova API)
- Sincronização de requisições: Fazer requisições HTTP síncronas usando o novo HttpClient.
- Assincronização de requisições: Realizar requisições HTTP assíncronas com suporte a CompletableFuture.
- WebSocket: Implementação de clientes WebSocket usando a nova API.
- Autenticação e Manipulação de Cookies: Gerenciamento de autenticação e cookies com HttpClient.
# 5. Novidades em Fluxos (Streams)
- Predicate.not(): Filtragem de streams de maneira mais clara ao negar predicados.
- takeWhile() e dropWhile(): Operações de curto-circuito em streams para maior controle de fluxo.
# 6. Melhorias em Coleções
- Imutabilidade: Métodos para criar coleções imutáveis de maneira mais fácil (List.of(), Set.of(), Map.of()).
# 7. Nest-Based Access Control
- Encapsulamento aprimorado: Controle de acesso mais refinado para classes aninhadas.
- Reflective Access: Controle sobre quais classes aninhadas podem ser acessadas por reflexão.
# 8. Novos Métodos no LocalDate e LocalTime
- LocalDate.of(int year, Month month, int dayOfMonth): Criação de datas com mais clareza. 
- LocalTime.of(int hour, int minute): Criação de horários com mais precisão.
# 9. ZGC (Z Garbage Collector)
- Exploração e configuração: Entender como utilizar e configurar o novo coletor de lixo de baixa latência introduzido no Java 11.
# 10. Compact Strings
- Exploração interna: Entendimento de como o Java 11 otimiza a representação de strings internamente para economizar memória.
# 11. Deprecated Features
- Explorar as funcionalidades que foram deprecated: Entendimento sobre o que foi marcado como obsoleto e o que usar no lugar.
# 12. Flight Recorder e Mission Control
- Monitoramento e diagnóstico: Utilização das ferramentas para monitoramento de desempenho e análise de falhas em aplicações Java.