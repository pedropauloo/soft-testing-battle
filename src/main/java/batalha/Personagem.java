package batalha;

public abstract class Personagem {
    String jogador;
    private Integer ataque;

    private Integer defesa;

    private Integer velocidade;

    private Integer resistencia;

    private Integer vida;

    public Personagem(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia) {
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.resistencia = resistencia;

        checarRegraDeClasse();
        checarTotal();
        checarValorMinimo();

        this.vida = 5 * this.resistencia;
    }

    public Personagem(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia, String jogador) {
        this(ataque, defesa, velocidade, resistencia);
        this.jogador = jogador;
    }

    abstract void checarRegraDeClasse() throws IllegalArgumentException;

    private void checarValorMinimo() {
        checarValorMinimo(ataque);
        checarValorMinimo(defesa);
        checarValorMinimo(velocidade);
        checarValorMinimo(resistencia);
    }

    final void checarValorMinimo(Integer atributo) {
        if (ataque < 3 || defesa < 3 || velocidade < 3 || resistencia < 3) {
            throw new IllegalArgumentException("Todos os atributos devem ser no mínimo 3.");
        }
    }

    final void checarTotal() {
        if (this.ataque + this.defesa + this.velocidade + this.resistencia != 20) {
            throw new IllegalStateException("Somatório dos atributos deve ser igual a 20.");
        }
    }

    public int atacar(Personagem defensor, double modificadorAtaque, boolean eGolpeCritico) {
        int danoBase = this.calcularDanoBase(modificadorAtaque);
        int dano = this.calcularDanoInfringindo(danoBase, defensor.getDefesa(), eGolpeCritico);

        defensor.receberDano(dano);

        return dano;
    }

    int calcularDanoInfringindo(int danoBase, int defesa, boolean eGolpeCritico) {
        int danoInfringido = Math.max(1, danoBase - defesa);

        if (eGolpeCritico) {
            return (int) (danoInfringido * 1.5);
        }

        return danoInfringido;
    }

    private void receberDano(int danoInfringido) {
        this.vida -= danoInfringido;
    }

    public int calcularDanoBase(double modificadorAtaque) {
        double danoBase = this.ataque * modificadorAtaque;

        return (int) Math.round(danoBase);
    }

    public Integer getAtaque() {
        return ataque;
    }

    void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    void setDefesa(Integer defesa) {
        this.defesa = defesa;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public Integer getResistencia() {
        return resistencia;
    }

    void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public String getJogador() {
        return jogador;
    }
}
