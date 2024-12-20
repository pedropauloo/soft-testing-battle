package batalha;

public class Main {
    private static void showErrorMessage(String message) {
        try {
            System.err.println(message);
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    private static Personagem escolherPersonagem(int opcao) {
        try {
            switch (opcao) {
                case 1:
                    return getPersonagemAtributos().doTipoAssassino();
                case 2:
                    return getPersonagemAtributos().doTipoGuerreiro();
                case 0:
                    System.exit(0);
                default:
                    Main.showErrorMessage("Opção inválida");
                    return escolherPersonagem();
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            Main.showErrorMessage(e.getMessage());

            return escolherPersonagem(opcao);
        }
    }

    private static Personagem escolherPersonagem() {
        System.out.println("1 - Assassino");
        System.out.println("2 - Guerreiro");
        System.out.println("0 - Sair");

        int opcao = Integer.parseInt(System.console().readLine());
        return escolherPersonagem(opcao);
    }

    private static PersonagemBuilder getPersonagemAtributos() {
        PersonagemBuilder personagemBuilder = new PersonagemBuilder();
        System.out.println("Escolha os atributos:");

        System.out.print("Ataque: ");
        personagemBuilder.comAtaque(Integer.parseInt(System.console().readLine()));

        System.out.print("Defesa: ");
        personagemBuilder.comDefesa(Integer.parseInt(System.console().readLine()));

        System.out.print("Velocidade: ");
        personagemBuilder.comVelocidade(Integer.parseInt(System.console().readLine()));

        System.out.print("Resistencia: ");
        personagemBuilder.comResistencia(Integer.parseInt(System.console().readLine()));

        return personagemBuilder;
    }

    public static void main(String[] args) {
        System.out.println("Jogo de Batalha");
        System.out.println("Escolha o personagem 1:");
        Personagem p1 = escolherPersonagem();

        System.out.println("Escolha o personagem 2:");
        Personagem p2 = escolherPersonagem();

        Batalha batalha = new Batalha(p1, p2);

        while (true) {
            batalha.realizarPrimeiroAtaque();

            if (batalha.temVencedor()) {
                System.out.println("O vencedor é: " + batalha.getVencedor().getClass().getSimpleName());
                break;
            }

            batalha.realizarSegundoAtaque();

            if (batalha.temVencedor()) {
                System.out.println("O vencedor é: " + batalha.getVencedor().getClass().getSimpleName());
                break;
            }

        }

    }
}