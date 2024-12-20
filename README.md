# README - Projeto Batalha por Turnos

## Autores

- **Samuel de Araujo Costa**  
- **Pedro Paulo Lucas de Lira**  
- **José Ben Hur Nascimento**  

---

## Introdução

Este projeto consiste em um jogo de **batalha por turnos**, desenvolvido como parte da disciplina de **Teste de Software**. O jogo permite que dois personagens batalhem entre si, seguindo regras específicas e realizando ações como ataque, defesa, e evasão. Cada personagem pode pertencer a uma das seguintes classes: **Guerreiro** ou **Assassino**, e cada classe possui restrições específicas para a distribuição dos atributos.

Os principais objetivos do projeto incluem:

1. **Implementar as regras de negócio** definidas para o jogo.
2. **Desenvolver testes automatizados** com **JUnit 5** para validar as regras.
3. **Garantir 100% de cobertura de arestas** no código utilizando ferramentas como **JaCoCo**.
4. Aplicar o critério **MC/DC (Modified Condition/Decision Coverage)** ao `if` mais complexo do código.
5. Fornecer uma documentação clara e completa para o projeto.

---

## Instruções de Compilação e Execução

*(Espaço reservado para implementação futura.)*

---

## Como Executar os Testes

*(Espaço reservado para implementação futura.)*

---

## Como Gerar o Relatório de Cobertura

*(Espaço reservado para implementação futura.)*

---

## Dependências

*(Espaço reservado para implementação futura.)*

---

## Uso do Programa

*(Espaço reservado para implementação futura.)*


# Documentação das Regras de Negócio

## Regra 1: Soma dos Atributos Igual a 20

### 1.1. Descrição das Partições

- **Partição Válida**: A soma de ataque, defesa, velocidade e resistência é exatamente 20.
- **Partição Inválida**: A soma dos atributos é diferente de 20:
    - Menor que 20.
    - Maior que 20.

### 1.2. Análise dos Valores Limites Identificados

- **Limite Inferior**: Soma = 19 (inválido).
- **Valor Válido**: Soma = 20.
- **Limite Superior**: Soma = 21 (inválido).

### 1.3. Tabela de Decisão

| **Condição**                      | **Ação**                            |
|-----------------------------------|-------------------------------------|
| Soma dos atributos = 20           | Atributos válidos                   |
| Soma dos atributos < 20           | Lançar exceção: "Somatório menor que 20" |
| Soma dos atributos > 20           | Lançar exceção: "Somatório maior que 20" |

---

## Regra 2: Validação dos Valores Mínimos dos Atributos

### 2.1. Descrição das Partições Identificadas

- **Partição Válida**: Todos os atributos (ataque, defesa, velocidade, resistência) possuem valor ≥ 3.
- **Partição Inválida**: Algum atributo possui valor < 3.

### 2.2. Análise dos Valores Limites Identificados

- **Limite Inferior**: Atributo = 2 (inválido).
- **Valor Válido**: Atributo = 3.
- **Valor Acima do Limite**: Atributo = 4 (válido).

### 2.3. Tabela de Decisão

| **Condição**                     | **Ação**                                     |
|----------------------------------|----------------------------------------------|
| Todos os atributos ≥ 3           | Atributos válidos                            |
| Algum atributo < 3               | Lançar exceção: "Atributo abaixo do limite permitido" |

---

## Regra 3: Seleção do Primeiro Atacante

### 3.1. Descrição das Partições Identificadas

- **Partição 1**: Velocidade P1 > Velocidade P2 → P1 ataca primeiro.
- **Partição 2**: Velocidade P1 < Velocidade P2 → P2 ataca primeiro.
- **Partição 3**: Velocidade P1 == Velocidade P2 → O atacante é escolhido aleatoriamente.

### 3.2. Análise dos Valores Limites Identificados

- **Limite Inferior**: Velocidade P1 = Velocidade P2 - 1.
- **Valor de Empate**: Velocidade P1 = Velocidade P2.
- **Limite Superior**: Velocidade P1 = Velocidade P2 + 1.

### 3.3. Tabela de Decisão

| **Condição**                    | **Ação**                           |
|---------------------------------|------------------------------------|
| Velocidade P1 > Velocidade P2   | P1 ataca primeiro                  |
| Velocidade P1 < Velocidade P2   | P2 ataca primeiro                  |
| Velocidade P1 == Velocidade P2  | Escolha aleatória do atacante      |

---

## Regra 4: Cálculo de Evasão

### 4.1. Descrição das Partições Identificadas

- **Partição Válida**: A chance de evasão está entre 0% e 50%.
- **Partição Inválida**: Chance fora desse intervalo (não ocorre no código atual).

### 4.2. Análise dos Valores Limites Identificados

- **Limite Inferior**: Chance de Evasão = 0%.
- **Limite Superior**: Chance de Evasão = 50%.

### 4.3. Tabela de Decisão

| **Condição**                                      | **Ação**                                 |
|--------------------------------------------------|------------------------------------------|
| Velocidade do defensor > Velocidade do atacante | Evasão calculada entre 0% e 50%          |
| Velocidade do defensor <= Velocidade do atacante| Chance de evasão = 0%                    |

---

## Regra 5: Regras Específicas de Classes (Assassino e Guerreiro)

### 5.1. Descrição das Partições Identificadas

#### **Classe Assassino**

- **Partição Válida**:
    - Ataque igual à Velocidade.
    - Resistência e Defesa menores ou iguais a Ataque e Velocidade.

- **Partição Inválida**:
    - Ataque maior que Velocidade.
    - Velocidade maior que Ataque.
    - Resistência ou Defesa maiores que Ataque ou Velocidade.

#### **Classe Guerreiro**

- **Partição Válida**:
    - Ataque igual à Resistência.
    - Velocidade e Defesa menores ou iguais a Ataque e Resistência.

- **Partição Inválida**:
    - Ataque maior que Resistência.
    - Resistência maior que Ataque.
    - Velocidade ou Defesa maiores que Ataque ou Resistência.

### 5.2. Análise dos Valores Limites Identificados

**Para o Assassino**:
- **Limite Inferior**: Ataque ≠ Velocidade (inválido).
- **Valor Válido**: Ataque = Velocidade e restrições atendidas.
- **Valor Superior**: Defesa ou Resistência > Ataque ou Velocidade (inválido).

**Para o Guerreiro**:
- **Limite Inferior**: Ataque ≠ Resistência (inválido).
- **Valor Válido**: Ataque = Resistência e restrições atendidas.
- **Valor Superior**: Velocidade ou Defesa > Ataque ou Resistência (inválido).

### 5.3. Tabela de Decisão

| **Classe**   | **Condição**                                      | **Ação**                                     |
|--------------|---------------------------------------------------|----------------------------------------------|
| Assassino    | Ataque == Velocidade                             | Válido                                       |
| Assassino    | Resistência ou Defesa ≤ Ataque e Velocidade      | Válido                                       |
| Assassino    | Caso contrário                                    | Lançar exceção: "Regras de classe violadas"  |
| Guerreiro    | Ataque == Resistência                            | Válido                                       |
| Guerreiro    | Velocidade ou Defesa ≤ Ataque e Resistência      | Válido                                       |
| Guerreiro    | Caso contrário                                    | Lançar exceção: "Regras de classe violadas"  |

---

## Regra 6: Cálculo de Dano

### 6.1. Descrição das Partições Identificadas

- **Partição Válida**:
    - Modificador de ataque no intervalo de [0.8, 1.2[.
    - Presença ou ausência de golpe crítico.

    - Golpe crítico aumenta o dano base em 50%.

- **Partição Inválida**:
    - Modificador fora do intervalo [0.8, 1.2[.
    - Cálculo incorreto do golpe crítico.

### 6.2. Análise dos Valores Limites Identificados

- **Limite Inferior**: Modificador = 0.7 (inválido).
- **Valor Válido**: Modificador = 0.8.
- **Valor Válido**: Modificador = 1.1.
- **Limite Superior**: Modificador = 1.2 (inválido).

### 6.3. Tabela de Decisão

| **Condição**                     | **Ação**                             |
|----------------------------------|--------------------------------------|
| Modificador dentro de [0.8, 1.2[| Cálculo normal                       |
| Modificador fora do intervalo    | Erro: "Modificador inválido"         |
| Golpe crítico                    | Multiplicar dano por 1.5             |
| Sem golpe crítico                | Não alterar dano base                |

---

## Regra 7: Vencedor da Batalha

### 7.1. Descrição das Partições Identificadas

- **Partição Válida**: Um personagem vence quando o HP do oponente chega a 0.
- **Partição Inválida**: Ambos os personagens ainda têm HP maior que 0 e o jogo finaliza.

### 7.2. Análise dos Valores Limites Identificados

- **Limite Inferior**: HP < 0 (inválido).
- **Valor Válido**: HP = 0.
- **Limite Superior**: Ambos os personagens têm HP > 0.

### 7.3. Tabela de Decisão

| **Condição**               | **Ação**                               |
|-----------------------------|----------------------------------------|
| HP de P1 ou P2 = 0         | Declarar vencedor                      |
| Ambos os HP > 0            | Batalha continua                       |
| HP de P1 ou P2 < 0         | Erro: “HP não pode ser negativo”       |

## Casos de Teste - Personagem

### 8.1. Identificação e Descrição
#### Exemplo: Caso de Teste CT01
- **Regra**: Ataque >= Velocidade (Assassino).
- **Descrição**: Verifica se o sistema aceita personagens Assassinos onde o Ataque é maior ou igual à Velocidade.
- **Entradas**: Ataque = 6, Velocidade = 6, Defesa = 4, Resistência = 4.
- **Saída Esperada**: Personagem criado com sucesso.
- **Pré-condição**: Somatório de atributos = 20.
- **Pós-condição**: Objeto válido da classe Assassino.

### 8.2. Implementação
- Testes foram implementados em `PersonagemTest.java`.
- Testes parametrizados cobrem cenários de partições válidas e inválidas.

## 9. Cobertura de Testes

### 9.1. Relatório de Cobertura
- Ferramenta utilizada: JaCoCo.
- **Cobertura alcançada**:
  - Cobertura de arestas: 100%.
  - Cobertura de instruções: 98%.

## 10. Critério MC/DC

### 10.1. If mais complexo

### 10.2. Casos de Teste

## 11. Rastreabilidade