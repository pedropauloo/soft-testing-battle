package batalha;

public class Interface {
    static void exibirMensagemErro(String message) {
        try {
            System.err.println(message);
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    static void exibirEvasao(Personagem atacante, Personagem defensor) {
        String jogadorAtacante = atacante.getJogador() + " (" + atacante.getClass().getSimpleName() + ")";
        String jogadorDefensor = defensor.getJogador() + " (" + defensor.getClass().getSimpleName() + ")";

        System.out.println();
        System.out.println(jogadorAtacante + " atacou " + jogadorDefensor + " mas evadiu");
        System.out.println(jogadorAtacante + " vida: " + atacante.getVida());
        System.out.println(jogadorDefensor + " vida: " + defensor.getVida());
        System.out.println();

        try {
            Thread.sleep(300);
        } catch (InterruptedException ignored) {
        }
    }

    static void exibirAtaque(Personagem atacante, Personagem defensor, int dano, boolean eGolpeCritico) {
        try {
            String golpeCritico = eGolpeCritico ? " com golpe crítico" : "";
            String jogadorAtacante = atacante.getJogador() + " (" + atacante.getClass().getSimpleName() + ")";
            String jogadorDefensor = defensor.getJogador() + " (" + defensor.getClass().getSimpleName() + ")";

            System.out.println();
            System.out.println(jogadorAtacante + " atacou " + jogadorDefensor + " com dano " + dano + golpeCritico);
            System.out.println(jogadorAtacante + " vida: " + atacante.getVida());
            System.out.println(jogadorDefensor + " vida: " + defensor.getVida());
            System.out.println();

            Thread.sleep(300);
        } catch (InterruptedException ignored) {
        }
    }
}
