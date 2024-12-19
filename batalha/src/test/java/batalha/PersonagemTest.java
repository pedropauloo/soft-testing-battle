package batalha;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonagemTest {
    @Test
    void testTotalPontosInferior() {
        Exception exception = assertThrows(IllegalStateException.class, () ->
                new Assassino(8, 3, 4, 4));
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }

    @Test
    void testTotalPontosCorreto() {
        assertDoesNotThrow(() -> new Guerreiro(6, 5, 5, 4));
    }

    @Test
    void testTotalPontosSuperior() {
        Exception exception = assertThrows(IllegalStateException.class, () ->
                new Guerreiro(7, 6, 5, 3));
        assertEquals("Somatório dos atributos deve ser igual a 20.", exception.getMessage());
    }
    @Test
    void testMinVarOkay(){
        assertDoesNotThrow(() ->new Guerreiro(6, 5, 4, 5));
    }
    @Test
    void testMinVarNotOkay(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Guerreiro(6, 6, 2, 6));
        assertEquals("Todos os atributos devem ser no mínimo 3.", exception.getMessage());
    }

}
