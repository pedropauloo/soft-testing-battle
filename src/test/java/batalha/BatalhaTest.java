package batalha;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BatalhaTest {

    @Test
    public void testPersonagem1MaiorVelocidadeAtacaPrimeiro() {
        Personagem p1 = PersonagemBuilder.construaUmPersonagem().comAtaque(6).comDefesa(4).comVelocidade(6).comResistencia(4).doTipoAssassino();
        Personagem p2 = PersonagemBuilder.construaUmPersonagem().comAtaque(5).comDefesa(5).comVelocidade(5).comResistencia(5).doTipoAssassino();

        Batalha batalha = new Batalha(p1, p2);

        assertEquals(batalha.getPrimeiroAtacante(), p1);
    }

    @Test
    public void testPersonagem2MaiorVelocidadeAtacaPrimeiro() {
        Personagem p1 = PersonagemBuilder.construaUmPersonagem().comAtaque(5).comDefesa(5).comVelocidade(5).comResistencia(5).doTipoAssassino();
        Personagem p2 = PersonagemBuilder.construaUmPersonagem().comAtaque(6).comDefesa(4).comVelocidade(6).comResistencia(4).doTipoAssassino();

        Batalha batalha = new Batalha(p1, p2);

        assertEquals(batalha.getPrimeiroAtacante(), p2);
    }

    @Test
    public void testPersonagensVelocidadeEmpatada() {
        Personagem p1 = PersonagemBuilder.construaUmPersonagem().comAtaque(5).comDefesa(5).comVelocidade(5).comResistencia(5).doTipoAssassino();
        Personagem p2 = PersonagemBuilder.construaUmPersonagem().comAtaque(5).comDefesa(5).comVelocidade(5).comResistencia(5).doTipoAssassino();

        Batalha batalha = new Batalha(p1, p2, 1);

        assertEquals(batalha.getPrimeiroAtacante(), p2);
    }

    @Test
    public void testDefensorEvadiu() {
        Personagem atacante = PersonagemBuilder.construaUmPersonagem().comAtaque(5).comDefesa(5).comVelocidade(5).comResistencia(5).doTipoAssassino();
        Personagem defensor = PersonagemBuilder.construaUmPersonagem().comAtaque(7).comDefesa(3).comVelocidade(7).comResistencia(3).doTipoAssassino();

        int chanceEvasao = Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());
        assertTrue(Batalha.evadiu(chanceEvasao, 3));
    }

    @Test
    public void testDefensorNaoEvadiu() {
        Personagem atacante = PersonagemBuilder.construaUmPersonagem().comAtaque(5).comDefesa(5).comVelocidade(5).comResistencia(5).doTipoAssassino();
        Personagem defensor = PersonagemBuilder.construaUmPersonagem().comAtaque(7).comDefesa(3).comVelocidade(7).comResistencia(3).doTipoAssassino();

        int chanceEvasao = Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());
        assertFalse(Batalha.evadiu(chanceEvasao, 50));
    }

    @Test
    public void testDefensorNaoEvadiuComChanceZero() {
        Personagem atacante = PersonagemBuilder.construaUmPersonagem().comAtaque(7).comDefesa(3).comVelocidade(7).comResistencia(3).doTipoAssassino();
        Personagem defensor = PersonagemBuilder.construaUmPersonagem().comAtaque(5).comDefesa(5).comVelocidade(5).comResistencia(5).doTipoAssassino();

        int chanceEvasao = Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());
        assertFalse(Batalha.evadiu(chanceEvasao, 1));
    }

   
}
