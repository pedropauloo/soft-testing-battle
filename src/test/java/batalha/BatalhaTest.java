package batalha;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

        assertEquals(batalha.getSegundoAtacante(), p1);
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

    @ParameterizedTest
    @CsvSource({
            "0.7",
            "1.2",
    })
    void testarModificadorDeAtaqueInvalido(double modificadorAtaque) {
        Personagem atacante = PersonagemBuilder.construaUmPersonagem()
                .comAtaque(5)
                .comDefesa(5)
                .comVelocidade(5)
                .comResistencia(5)
                .doTipoAssassino();
        Personagem defensor = PersonagemBuilder.construaUmPersonagem()
                .comAtaque(5)
                .comDefesa(5)
                .comVelocidade(5)
                .comResistencia(5)
                .doTipoAssassino();

        assertThrows(IllegalArgumentException.class, () -> {
            atacante.atacar(defensor, modificadorAtaque, false);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "0.8",
            "1.1",
    })
    void testarModificadorDeAtaqueValido(double modificadorAtaque) {
        Personagem atacante = PersonagemBuilder.construaUmPersonagem()
                .comAtaque(5)
                .comDefesa(5)
                .comVelocidade(5)
                .comResistencia(5)
                .doTipoAssassino();
        Personagem defensor = PersonagemBuilder.construaUmPersonagem()
                .comAtaque(5)
                .comDefesa(5)
                .comVelocidade(5)
                .comResistencia(5)
                .doTipoAssassino();

        assertDoesNotThrow(() -> {
            int dano = atacante.atacar(defensor, modificadorAtaque, false);

            assertTrue(dano > 0, "O dano deve ser maior que 0");
        });
    }

    @Test
    public void testarGolpeCritico() {
        Personagem atacante = PersonagemBuilder.construaUmPersonagem()
                .comAtaque(5)
                .comDefesa(5)
                .comVelocidade(5)
                .comResistencia(5)
                .doTipoAssassino();
        Personagem defensor = PersonagemBuilder.construaUmPersonagem()
                .comAtaque(5)
                .comDefesa(5)
                .comVelocidade(5)
                .comResistencia(5)
                .doTipoAssassino();

        Batalha batalha = new Batalha(atacante, defensor);

        double modificadorAtaque = 0.8;

        int danoRealizado = batalha.realizarAtaque(atacante, defensor, modificadorAtaque, 10);

        int danoBase = atacante.calcularDanoBase(modificadorAtaque);
        int danoInfringido = Math.max(1, danoBase - defensor.getDefesa());
        int danoEsperado = (int) Math.round(danoInfringido * 1.5);

        assertEquals(danoEsperado, danoRealizado, "O dano deve ser corretamente multiplicado por 1.5 no caso de golpe crítico");
    }

    @Test
    public void testarGolpeNaoCritico() {
        Personagem atacante = PersonagemBuilder.construaUmPersonagem()
                .comAtaque(5)
                .comDefesa(5)
                .comVelocidade(5)
                .comResistencia(5)
                .doTipoAssassino();
        Personagem defensor = PersonagemBuilder.construaUmPersonagem()
                .comAtaque(5)
                .comDefesa(5)
                .comVelocidade(5)
                .comResistencia(5)
                .doTipoAssassino();

        Batalha batalha = new Batalha(atacante, defensor);

        double modificadorAtaque = 0.8;

        int danoRealizado = batalha.realizarAtaque(atacante, defensor, modificadorAtaque, 50);

        int danoBase = atacante.calcularDanoBase(modificadorAtaque);
        int danoEsperado = Math.max(1, danoBase - defensor.getDefesa());

        assertEquals(danoEsperado, danoRealizado, "O dano não deve ser multiplicado por 1.5 quando não for golpe crítico");
    }

    @Test
    public void testPersonagem1Vencedor() {
        Personagem p1 = PersonagemBuilder.construaUmPersonagem().comAtaque(6).comDefesa(4).comVelocidade(6).comResistencia(4).doTipoAssassino();
        Personagem p2 = PersonagemBuilder.construaUmPersonagem().comAtaque(5).comDefesa(5).comVelocidade(5).comResistencia(5).doTipoAssassino();

        Batalha batalha = new Batalha(p1, p2);

        p2.setVida(0);

        batalha.realizarPrimeiroAtaque();

        assertTrue(batalha.temVencedor());
        assertEquals(batalha.getVencedor(), p1);
    }

    @Test
    public void testPersonagem2Vencedor() {
        Personagem p1 = PersonagemBuilder.construaUmPersonagem().comAtaque(6).comDefesa(4).comVelocidade(6).comResistencia(4).doTipoAssassino();
        Personagem p2 = PersonagemBuilder.construaUmPersonagem().comAtaque(5).comDefesa(5).comVelocidade(5).comResistencia(5).doTipoAssassino();

        Batalha batalha = new Batalha(p1, p2);

        batalha.realizarPrimeiroAtaque();

        p1.setVida(0);

        batalha.realizarSegundoAtaque();

        assertTrue(batalha.temVencedor());
        assertEquals(batalha.getVencedor(), p2);
    }

    @Test
    public void testNaoTemVencedor() {
        Personagem p1 = PersonagemBuilder.construaUmPersonagem()
                .comAtaque(6)
                .comDefesa(4)
                .comVelocidade(6)
                .comResistencia(4)
                .comJogador("Jogador 1")
                .doTipoAssassino();
        Personagem p2 = PersonagemBuilder.construaUmPersonagem()
                .comAtaque(5)
                .comDefesa(5)
                .comVelocidade(5)
                .comResistencia(5)
                .comJogador("Jogador 2")
                .doTipoGuerreiro();

        Batalha batalha = new Batalha(p1, p2);

        assertFalse(batalha.temVencedor());
    }
}
