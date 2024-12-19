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

    @Test
    void testCalcularChanceEvasao() {
        // Criar personagens para o teste
        Personagem defensor= new Assassino(7, 3, 7, 3); 
        Personagem atacante = new Guerreiro(7, 3, 3, 7); 
        // Velocidade do atacante é menor que do defensor
        int chanceEvasao = Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());
        assertEquals(50, chanceEvasao); // (5 - 4) * 2 = 2
    }
    @Test
    void testCalcularChanceEvasao2() {
        // Criar personagens para o teste
        Personagem defensor= new Assassino(6, 4, 6, 4); 
        Personagem atacante = new Guerreiro(7, 3, 3, 7); 
        // Velocidade do atacante é menor que do defensor
        int chanceEvasao = Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());
        assertEquals(37, chanceEvasao); // (5 - 4) * 2 = 2

    }

    @Test
    void testCalcularChanceEvasao3() {
        // Criar personagens para o teste
        Personagem defensor= new Assassino(6, 4, 6, 4); 
        Personagem atacante = new Guerreiro(6, 4, 4, 6); 
        // Velocidade do atacante é menor que do defensor
        int chanceEvasao = Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());
        assertEquals(25, chanceEvasao); // (5 - 4) * 2 = 2

    }
    @Test
    void testCalcularChanceEvasao4() {
        // Criar personagens para o teste
        Personagem defensor= new Guerreiro(6, 4, 4, 6); 
        Personagem atacante = new Guerreiro(7, 3, 3, 7); 
        // Velocidade do atacante é menor que do defensor
        int chanceEvasao = Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());
        assertEquals(12, chanceEvasao); // (5 - 4) * 2 = 2

    }
    private Batalha batalha;
    private Personagem atacante;
    private Personagem defensor;
    @Test
    void testAtaqueEvadiu() {

        Personagem defensor= new Assassino(7, 3, 7, 3); 
        Personagem atacante = new Guerreiro(7, 3, 3, 7);
        batalha = new Batalha(atacante, defensor);
        // Simulando o ataque
        int chanceEvasao = batalha.calcularChanceEvasao(atacante, defensor);
        
        // Simulando um número aleatório fixo para controle
        int randomicoEvasao = 20; // Simula um valor que deve resultar em evasão
        
        // Testar se o ataque é evadido
        assertTrue(batalha.evadiu(chanceEvasao, randomicoEvasao)); // Deve evadir, pois 20 <= 50
        
        // Testar com outro valor aleatório que não deve evadir
        
    }
    @Test
    void testAtaqueNãoEvadiu() {

        Personagem defensor= new Assassino(7, 3, 7, 3); 
        Personagem atacante = new Guerreiro(7, 3, 3, 7);
        batalha = new Batalha(atacante, defensor);
        // Simulando o ataque
        int chanceEvasao = batalha.calcularChanceEvasao(atacante, defensor);
        
        // Testar com outro valor aleatório que não deve evadir
        int randomicoEvasao = 60; // Simula um valor que não deve resultar em evasão
        assertFalse(batalha.evadiu(chanceEvasao, randomicoEvasao)); // Não deve evadir, pois 60 > 50
        
    }

}
