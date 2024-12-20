package batalha;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonagemTest {

    @ParameterizedTest
    @CsvSource({
            "5, 4, 6, 5",    // Ataque < Velocidade
            "6, 4, 5, 5",    // Velocidade < Ataque
            "5, 6, 4, 5",    // Defesa > Ataque
            "5, 4, 6, 5",    // Defesa > Velocidade
            "5, 4, 5, 6",    // Resistencia > Ataque
            "5, 5, 4, 6"     // Resistencia > Velocidade
    })
    void testAssassinoInvalido(int ataque, int defesa, int velocidade, int resistencia) {
        assertThrows(IllegalArgumentException.class, () -> {
            PersonagemBuilder.construaUmPersonagem()
                    .comAtaque(ataque)
                    .comDefesa(defesa)
                    .comVelocidade(velocidade)
                    .comResistencia(resistencia)
                    .doTipoAssassino();
        });
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
        }, "Nao esperava excecao para os atributos fornecidos.");
    }


    @ParameterizedTest
    @CsvSource({
            "7, 4, 4, 5",    // Resistencia < Ataque
            "5, 4, 4, 7",    // Ataque < Resistencia
            "5, 7, 3, 5",    // Defesa > Resistencia
            "5, 6, 4, 5",    // Defesa > Ataque
            "5, 3, 7, 5",    // Velocidade > Resistencia
            "5, 4, 6, 5",    // Velocidade > Ataque

    })
    void testGuerreiroInvalido(int ataque, int defesa, int velocidade, int resistencia) {
        assertThrows(IllegalArgumentException.class, () -> {
            PersonagemBuilder.construaUmPersonagem()
                    .comAtaque(ataque)
                    .comDefesa(defesa)
                    .comVelocidade(velocidade)
                    .comResistencia(resistencia)
                    .doTipoGuerreiro();
        });
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
        }, "Nao esperava excecao para os atributos fornecidos.");
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 4, 5",    // Soma < 20
            "8, 6, 6, 8",    // Soma > 20
    })
    void testSomaAtributosPersonagemInvalidas(int ataque, int defesa, int velocidade, int resistencia) {
        assertThrows(IllegalStateException.class, () -> {
            PersonagemBuilder.construaUmPersonagem()
                    .comAtaque(ataque)
                    .comDefesa(defesa)
                    .comVelocidade(velocidade)
                    .comResistencia(resistencia)
                    .doTipoGuerreiro();
        }, "Esperava excecao para os atributos fornecidos.");
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 5, 5",    // Soma = 20
            "6, 4, 6, 4",    // Soma = 20
            "6, 5, 6, 3",    // Soma = 20
            "6, 3, 6, 5",    // Soma = 20
    })
    void testSomaAtributosPersonagemValidas(int ataque, int defesa, int velocidade, int resistencia) {
        assertDoesNotThrow(() -> {
            PersonagemBuilder.construaUmPersonagem()
                    .comAtaque(ataque)
                    .comDefesa(defesa)
                    .comVelocidade(velocidade)
                    .comResistencia(resistencia)
                    .doTipoAssassino();
        }, "Nao esperava excecao para os atributos fornecidos.");
    }


    @ParameterizedTest
    @CsvSource({
            "2, 6, 6, 6",    // Ataque < 3
            "6, 2, 6, 6",    // Defesa < 3
            "6, 6, 2, 6",    // Velocidade < 3
            "6, 6, 6, 2",    // Resistencia < 3

    })
    void testPersonagemAtributoValorMinimoInvalido(int ataque, int defesa, int velocidade, int resistencia) {
        assertThrows(IllegalArgumentException.class, () -> {
            PersonagemBuilder.construaUmPersonagem()
                    .comAtaque(ataque)
                    .comDefesa(defesa)
                    .comVelocidade(velocidade)
                    .comResistencia(resistencia)
                    .doTipoGuerreiro();
        });
    }


    @ParameterizedTest
    @CsvSource({
            "7, 3, 3, 7",
            "6, 5, 3, 6",
            "6, 4, 4, 6",
            "6, 5, 3, 6",
            "5, 5, 5, 5"
    })
    void testPersonagemAtributoValorMinimoValidos(int ataque, int defesa, int velocidade, int resistencia) {
        assertDoesNotThrow(() -> {
            PersonagemBuilder.construaUmPersonagem()
                    .comAtaque(ataque)
                    .comDefesa(defesa)
                    .comVelocidade(velocidade)
                    .comResistencia(resistencia)
                    .doTipoGuerreiro();
        }, "Nao esperava excecao para os atributos fornecidos.");
    }
}
