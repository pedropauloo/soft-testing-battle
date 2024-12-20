package batalha;

import java.security.SecureRandom;

import static java.lang.Math.min;

public class Batalha {

    private final Personagem primeiroAtacante;

    private final Personagem segundoAtacante;

    private final SecureRandom geradorRandomico;

    private Personagem vencedor;

    Batalha(Personagem p1, Personagem p2, int randomico) {
        this.geradorRandomico = new SecureRandom();

        if (p1.getVelocidade() > p2.getVelocidade()) {
            this.primeiroAtacante = p1;
            this.segundoAtacante = p2;
        } else if (p1.getVelocidade() < p2.getVelocidade()) {
            this.primeiroAtacante = p2;
            this.segundoAtacante = p1;
        } else {
            if (randomico == 0) {
                this.primeiroAtacante = p1;
                this.segundoAtacante = p2;
            } else {
                this.primeiroAtacante = p2;
                this.segundoAtacante = p1;
            }
        }
    }

    public Batalha(Personagem p1, Personagem p2) {
        this(p1, p2, new SecureRandom().nextInt(2));
    }

    static int calcularChanceEvasao(int velocidadeAtacante, int velocidadeDefensor) {
        int chanceEvasao = min(50, (velocidadeDefensor - velocidadeAtacante) * 2);

        return Math.max(chanceEvasao, 0);
    }

    public void realizarPrimeiroAtaque() {
        realizarAtaque(primeiroAtacante, segundoAtacante);
    }

    public void realizarSegundoAtaque() {
        realizarAtaque(segundoAtacante, primeiroAtacante);
    }

    private boolean realizarAtaque(Personagem atacante, Personagem defensor) {
        int chanceEvasao = calcularChanceEvasao(atacante, defensor);
        int randomicoEvasao = geradorRandomico.nextInt(100);


        if (this.evadiu(chanceEvasao, randomicoEvasao)) {
            // Informar que evadiu
            return false;
        } else {
            double modificadorAtaque = 0.8 + (geradorRandomico.nextDouble() * (0.4));
            boolean eGolpeCritico = geradorRandomico.nextInt(1, 101) <= 10;

            int dano = atacante.atacar(defensor, modificadorAtaque, eGolpeCritico);

            exibirAtaque(atacante, defensor, dano, eGolpeCritico);

            // Informar que atacante atacou defensor
            return true;
        }
    }

    private void exibirAtaque(Personagem atacante, Personagem defensor, int dano, boolean eGolpeCritico) {
        try {
            String golpeCritico = eGolpeCritico ? " com golpe crítico" : "";
            String jogadorAtacante = atacante.getJogador() + " (" + atacante.getClass().getSimpleName() + ")";
            String jogadorDefensor = defensor.getJogador() + " (" + defensor.getClass().getSimpleName() + ")";

            System.out.println(jogadorAtacante + " atacou " + jogadorDefensor + " com dano " + dano + golpeCritico);

            Thread.sleep(300);
        } catch (InterruptedException ignored) {
        }
    }

    boolean evadiu(int chanceEvasao, int randomico) {
        return randomico <= chanceEvasao;
    }

    int calcularChanceEvasao(Personagem atacante, Personagem defensor) {
        return Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());
    }

    public boolean temVencedor() {
        if (primeiroAtacante.getVida() <= 0) {
            this.vencedor = segundoAtacante;
            return true;
        }
        if (segundoAtacante.getVida() <= 0) {
            this.vencedor = primeiroAtacante;
            return true;
        }

        return false;
    }

    public Personagem getVencedor() {
        return vencedor;
    }

    public Personagem getPrimeiroAtacante() {
        return primeiroAtacante;
    }

    public Personagem getSegundoAtacante() {
        return segundoAtacante;
    }

}
