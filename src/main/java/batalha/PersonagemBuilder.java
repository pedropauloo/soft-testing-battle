package batalha;

public class PersonagemBuilder {
    private String jogador;
    private Integer ataque;

    private Integer defesa;

    private Integer velocidade;

    private Integer resistencia;

    public static PersonagemBuilder construaUmPersonagem() {
        return new PersonagemBuilder();
    }

    public PersonagemBuilder comAtaque(Integer ataque) {
        this.ataque = ataque;
        return this;
    }

    public PersonagemBuilder comDefesa(Integer defesa) {
        this.defesa = defesa;
        return this;
    }

    public PersonagemBuilder comVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
        return this;
    }

    public PersonagemBuilder comResistencia(Integer resistencia) {
        this.resistencia = resistencia;
        return this;
    }

    public PersonagemBuilder comJogador(String jogador) {
        this.jogador = jogador;
        return this;
    }

    public Assassino doTipoAssassino() throws IllegalArgumentException {
        return new Assassino(ataque, defesa, velocidade, resistencia, jogador);
    }

    public Guerreiro doTipoGuerreiro() throws IllegalArgumentException {
        return new Guerreiro(ataque, defesa, velocidade, resistencia, jogador);
    }


}
