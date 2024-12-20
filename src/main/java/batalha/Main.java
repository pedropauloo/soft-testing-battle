package batalha;

public class Main {


    private static void batalhar(Personagem p1, Personagem p2) {
        Batalha batalha = new Batalha(p1, p2);

        System.out.println("O primeiro atacante é " + batalha.getPrimeiroAtacante().getJogador());
        System.out.println("O segundo atacante é " + batalha.getSegundoAtacante().getJogador());

        while (true) {
            batalha.realizarPrimeiroAtaque();

            if (batalha.temVencedor()) {
                System.out.println("O vencedor é " + batalha.getVencedor().getJogador());
                break;
            }

            batalha.realizarSegundoAtaque();

            if (batalha.temVencedor()) {
                System.out.println("O vencedor é " + batalha.getVencedor().getJogador());
                break;
            }
        }
    }

    private static Personagem escolherPersonagem(int opcao, String jogador) {
        try {
            switch (opcao) {
                case 1:
                    return getPersonagemAtributos().comJogador(jogador).doTipoAssassino();
                case 2:
                    return getPersonagemAtributos().comJogador(jogador).doTipoGuerreiro();
                case 0:
                    System.exit(0);
                default:
                    Interface.exibirMensagemErro("Opção inválida");
                    return escolherPersonagem(jogador);
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            Interface.exibirMensagemErro(e.getMessage());

            return escolherPersonagem(opcao, jogador);
        }
    }

    private static Personagem escolherPersonagem(String jogador) {
        System.out.println("1 - Assassino");
        System.out.println("2 - Guerreiro");
        System.out.println("0 - Sair");
        return escolherPersonagem(Integer.parseInt(System.console().readLine()), jogador);
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
        Personagem p1 = escolherPersonagem("Jogador 1");

        System.out.println("Escolha o personagem 2:");
        Personagem p2 = escolherPersonagem("Jogador 2");

        batalhar(p1, p2);

        while (true) {
            System.out.println("Fim de jogo");
            System.out.println("Deseja tentar uma nova batalha?");
            System.out.println("1 - Sim");
            System.out.println("0 - Não");

            switch (Integer.parseInt(System.console().readLine())) {
                case 1:
                    main(args);
                    break;
                case 0:
                    System.exit(0);
                default:
                    Interface.exibirMensagemErro("Opção inválida");
            }
        }
    }
}