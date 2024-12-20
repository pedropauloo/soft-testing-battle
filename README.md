### Rodar a demonstração do projeto

1. Clone o repositório
2. Abra o terminal e execute o comando `mvn clean install`
3. Em seguida, execute o comando `mvn exec:java -Dexec.mainClass="batalha.Main"` para rodar a demonstração

### Como testar

1. Abra o terminal e execute o comando `mvn clean test` para rodar os testes
2. Para visualizar a cobertura de código, acesse o seguinte diretorio `target/site/jacoco/index.html` e abra o
   arquivo `index.html` no navegador para visualizar o relatório de cobertura de código