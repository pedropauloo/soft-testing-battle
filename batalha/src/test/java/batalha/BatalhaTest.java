package batalha;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BatalhaTest {
    @Test
    void testPrimeiroAtacanteVelocidadeMaior() {
        Personagem personagem1 = new Assassino(7, 3, 7, 3); 
        Personagem personagem2 = new Assassino(6, 4, 6, 4); 

        Batalha batalha = new Batalha(personagem1, personagem2, 0);
        assertEquals(personagem1, batalha.getPrimeiroAtacante(), "Personagem 1 deveria ser o primeiro atacante.");
        assertEquals(personagem2, batalha.getSegundoAtacante(), "Personagem 2 deveria ser o segundo atacante.");
    }

    @Test
    void testPrimeiroAtacanteVelocidadeMenor() {
        Personagem personagem1 = new Assassino(6, 4, 6, 4); 
        Personagem personagem2 = new Assassino(7, 3, 7, 3); 

        Batalha batalha = new Batalha(personagem1, personagem2, 0);
        assertEquals(personagem2, batalha.getPrimeiroAtacante(), "Personagem 2 deveria ser o primeiro atacante.");
        assertEquals(personagem1, batalha.getSegundoAtacante(), "Personagem 1 deveria ser o segundo atacante.");
    }

    @Test
    void testPrimeiroAtacanteVelocidadeIgualRandomicoZero() {
        Personagem personagem1 = new Assassino(7, 3, 7, 3); 
        Personagem personagem2 = new Assassino(7, 3, 7, 3); 

        Batalha batalha = new Batalha(personagem1, personagem2, 0);
        assertEquals(personagem1, batalha.getPrimeiroAtacante(), "Personagem 1 deveria ser o primeiro atacante quando randomico é 0.");
        assertEquals(personagem2, batalha.getSegundoAtacante(), "Personagem 2 deveria ser o segundo atacante quando randomico é 0.");
    }

    @Test
    void testPrimeiroAtacanteVelocidadeIgualRandomicoUm() {
        Personagem personagem1 = new Assassino(6, 4, 6, 4); 
        Personagem personagem2 = new Assassino(6, 4, 6, 4); 

        Batalha batalha = new Batalha(personagem1, personagem2, 1);
        assertEquals(personagem2, batalha.getPrimeiroAtacante(), "Personagem 2 deveria ser o primeiro atacante quando randomico é 1.");
        assertEquals(personagem1, batalha.getSegundoAtacante(), "Personagem 1 deveria ser o segundo atacante quando randomico é 1.");
    }
}
