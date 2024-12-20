package batalha;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonagemTest {

    @ParameterizedTest
    @CsvSource({
            "2, 5, 5, 5",    // Ataque < 3
            "5, 2, 5, 5",    // Defesa < 3
            "5, 5, 2, 5",    // Velocidade < 3
            "5, 5, 5, 2",    // Resistencia < 3
            "5, 5, 5, 4",    // Soma < 20
            "8, 6, 6, 5",    // Soma > 20
            "5, 3, 6, 5",    // Ataque < Velocidade
            "6, 3, 5, 5",    // Velocidade < Ataque
            "5, 6, 5, 5",    // Defesa > Ataque
            "5, 5, 6, 5",    // Defesa > Velocidade
            "5, 5, 5, 6",    // Resistencia > Ataque
            "5, 5, 5, 6"     // Resistencia > Velocidade
    })
    void testAssassinoInvalido(int ataque, int defesa, int velocidade, int resistencia) {
        Throwable exception = assertThrows(Throwable.class, () -> {
            PersonagemBuilder.construaUmPersonagem()
                    .comAtaque(ataque)
                    .comDefesa(defesa)
                    .comVelocidade(velocidade)
                    .comResistencia(resistencia)
                    .doTipoAssassino();
        });

        assertTrue(
                exception instanceof IllegalArgumentException || exception instanceof IllegalStateException,
                "Esperava IllegalArgumentException ou IllegalStateException, mas foi lancado: " + exception.getClass().getName()
        );
    }

    @ParameterizedTest
    @CsvSource({
            "7, 3, 7, 3",
            "6, 5, 6, 3",
            "6, 4, 6, 4",
            "6, 5, 6, 3",
            "5, 5, 5, 5"
    })
    void testAssassinoValido(int ataque, int defesa, int velocidade, int resistencia) {
        assertDoesNotThrow(() -> {
            PersonagemBuilder.construaUmPersonagem()
                    .comAtaque(ataque)
                    .comDefesa(defesa)
                    .comVelocidade(velocidade)
                    .comResistencia(resistencia)
                    .doTipoAssassino();
        }, "Noa esperava excecao para os atributos fornecidos.");
    }


    @ParameterizedTest
    @CsvSource({
            "7, 7, 7, 7",    // Soma > 20
            "4, 4, 4, 4",    // Soma < 20
            "2, 5, 5, 5",    // Ataque < 3
            "5, 2, 5, 5",    // Defesa < 3
            "5, 5, 2, 5",    // Velocidade < 3
            "5, 5, 5, 2",    // Resistencia < 3
            "7, 4, 4, 5",    // Resistencia < Ataque
            "5, 4, 4, 7",    // Ataque < Resistencia
            "5, 7, 3, 5",    // Defesa > Resistencia
            "5, 6, 4, 5",    // Defesa > Ataque
            "5, 3, 7, 5",    // Velocidade > Resistencia
            "5, 6, 4, 5",    // Velocidade > Ataque

    })
    void testGuerreiroInvalido(int ataque, int defesa, int velocidade, int resistencia) {
        Throwable exception = assertThrows(Throwable.class, () -> {
            PersonagemBuilder.construaUmPersonagem()
                    .comAtaque(ataque)
                    .comDefesa(defesa)
                    .comVelocidade(velocidade)
                    .comResistencia(resistencia)
                    .doTipoGuerreiro();
        });

        assertTrue(
                exception instanceof IllegalArgumentException || exception instanceof IllegalStateException,
                "Esperava IllegalArgumentException ou IllegalStateException, mas foi lançado: " + exception.getClass().getName()
        );
    }

    @ParameterizedTest
    @CsvSource({
            "7, 3, 3, 7",
            "6, 5, 3, 6",
            "6, 4, 4, 6",
            "6, 5, 3, 6",
            "5, 5, 5, 5"
    })
    void testGuerreiroValido(int ataque, int defesa, int velocidade, int resistencia) {
        assertDoesNotThrow(() -> {
            PersonagemBuilder.construaUmPersonagem()
                    .comAtaque(ataque)
                    .comDefesa(defesa)
                    .comVelocidade(velocidade)
                    .comResistencia(resistencia)
                    .doTipoGuerreiro();
        }, "Noa esperava excecao para os atributos fornecidos.");
    }
}
