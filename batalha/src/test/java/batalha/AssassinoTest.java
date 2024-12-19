package batalha;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssassinoTest {
    @Test
    void testRegrasValidas() {
        // Teste com atributos válidos para a classe Assassino
        assertDoesNotThrow(() -> {
            Assassino assassino = new Assassino(7, 3, 7, 3);
            assassino.checarRegraDeClasse();
        });
    }

    @Test
    void testAtaqueMenorQueVelocidade() {
        // Teste onde o ataque é menor que a velocidade (regra violada)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Assassino assassino = new Assassino(6, 4, 7, 3);
            assassino.checarRegraDeClasse();
        });
        assertEquals("Ataque deve ser maior ou igual à Velocidade.", exception.getMessage());
    }

    @Test
    void testVelocidadeMenorQueAtaque() {
        // Teste onde a velocidade é menor que o ataque (regra violada)
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Assassino assassino = new Assassino(7, 4, 6, 3);
            assassino.checarRegraDeClasse();
        });
        assertEquals("Velocidade deve ser maior ou igual ao Ataque.", exception.getMessage());
    }

    @Test
    void testResistenciaMaiorQueAtaqueOuVelocidade() {
        // Teste onde a resistência é maior que o ataque ou velocidade
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Assassino assassino = new Assassino(5, 3, 5, 7); // Resistencia > Ataque e Velocidade
            assassino.checarRegraDeClasse();
        });
        assertEquals("Resistência deve ser menor ou igual a Ataque e Velocidade.", exception.getMessage());
    }

    @Test
    void testDefesaMaiorQueAtaqueOuVelocidade() {
        // Teste onde a defesa é maior que o ataque ou velocidade
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Assassino assassino = new Assassino(5, 7, 5, 3); // Defesa > Ataque e Velocidade
            assassino.checarRegraDeClasse();
        });
        assertEquals("Defesa deve ser menor ou igual a Ataque e Velocidade.", exception.getMessage());
    }
}
