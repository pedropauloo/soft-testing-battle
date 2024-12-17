package batalha;

public abstract class Personagem {
	private Integer ataque;

	private Integer defesa;

	private Integer velocidade;

	private Integer resistencia;

	private Integer vida;

	Personagem() {
	}

	public Personagem(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia) {
		this.ataque = ataque;
		this.defesa = defesa;
		this.velocidade = velocidade;
		this.resistencia = resistencia;

		checarTotal();
		checarValorMinimo();
		checarRegraDeClasse();

		this.vida = 5 * this.resistencia;
	}

	abstract void checarRegraDeClasse();

	private void checarValorMinimo() {
		checarValorMinimo(ataque);
		checarValorMinimo(defesa);
		checarValorMinimo(velocidade);
		checarValorMinimo(resistencia);
	}

	final void checarValorMinimo(Integer atributo) {
		// TODO
	}

	final void checarTotal() {
		if (this.ataque + this.defesa + this.velocidade + this.resistencia != 20) {
			throw new IllegalStateException("Somatório dos atributos deve ser igual a 20.");
		}
	}

	public void atacar(Personagem defensor, double modificadorAtaque, boolean eGolpeCritico) {
		int danoBase = this.calcularDanoBase(modificadorAtaque);
		int dano = this.calcularDanoInfringindo(danoBase, defensor.getDefesa(), eGolpeCritico);
		defensor.receberDano(dano);
	}

	int calcularDanoInfringindo(int danoBase, int defesa, boolean eGolpeCritico) {
		// TODO
		return -1;
	}

	private void receberDano(int danoInfringido) {
		// TODO
	}

	public int calcularDanoBase(double modificadorAtaque) {
		// TODO Considere que o modificadorAtaque é um valor entre [0.8 e 1.2[
		// 		Ele serve de base pra calcular o danoBase
		//		Recebe como parâmetro para isolar melhor o método, facilitando seu teste
		return -1;
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
}
