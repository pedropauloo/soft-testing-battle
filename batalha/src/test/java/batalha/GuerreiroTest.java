package batalha;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuerreiroTest {
    @Test
    void testRegrasValidas() {
        // Teste com atributos válidos para a classe Guerreiro
        assertDoesNotThrow(() -> {
            Guerreiro guerreiro = new Guerreiro(6, 4, 4, 6); // Total 20 pontos, regras respeitadas
            guerreiro.checarRegraDeClasse();
        });
    }

    @Test
    void testResistenciaMenorQueAtaque() {
        // Teste onde a resistência é menor que o ataque (regra violada)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Guerreiro guerreiro = new Guerreiro(7, 5, 4, 3); // Resistência < Ataque
            guerreiro.checarRegraDeClasse();
        });
        assertEquals("Resistencia deve ser maior ou igual ao Ataque.", exception.getMessage());
    }

    @Test
    void testAtaqueMenorQueResistencia() {
        // Teste onde o ataque é menor que a resistência (regra violada)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Guerreiro guerreiro = new Guerreiro(5, 5, 4, 6); // Ataque < Resistência
            guerreiro.checarRegraDeClasse();
        });
        assertEquals("Ataque deve ser maior ou igual à Resistencia.", exception.getMessage());
    }

    @Test
    void testVelocidadeMaiorQueResistenciaOuAtaque() {
        // Teste onde a dvelocidade é maior que a resistência ou ataque (regra violada)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Guerreiro guerreiro = new Guerreiro(5, 3, 7, 5); // Velocidade > Ataque ou Resistência
            guerreiro.checarRegraDeClasse();
        });
        assertEquals("Velocidade deve ser menor ou igual a Ataque e Resistencia.", exception.getMessage());
    }

    @Test
    void testDefesaOMaiorQueResistenciaOuAtaque() {
        // Teste onde a defesa é maior que a resistência ou ataque (regra violada)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Guerreiro guerreiro = new Guerreiro(5, 7, 3, 5); // Defesa > Ataque ou Resistência
            guerreiro.checarRegraDeClasse();
        });
        assertEquals("Defesa deve ser menor ou igual a Ataque e Resistencia.", exception.getMessage());
    }

    @Test // pode ser removido, usei apenas de teste
    void testAtributosAbaixoDoValorMinimo() {
        // Teste onde algum atributo é menor que 3 (regra violada)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Guerreiro guerreiro = new Guerreiro(7, 2, 4, 7); 
            guerreiro.checarRegraDeClasse();
        });
        assertEquals("Todos os atributos devem ser no mínimo 3.", exception.getMessage());
    }
}
