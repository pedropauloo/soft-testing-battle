package batalha;

public class Assassino extends Personagem {

	public Assassino(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia) {
		super(ataque, defesa, velocidade, resistencia);
	}

	@Override
	final void checarRegraDeClasse() {
		if (getAtaque() < getVelocidade()) {
            throw new IllegalArgumentException("Ataque deve ser maior ou igual à Velocidade.");
        }
        if (getVelocidade() < getAtaque()) {
            throw new IllegalArgumentException("Velocidade deve ser maior ou igual ao Ataque.");
        }
        if (getResistencia() > getAtaque() || getResistencia() > getVelocidade()) {
            throw new IllegalArgumentException("Resistência deve ser menor ou igual a Ataque e Velocidade.");
        }
        if (getDefesa() > getAtaque() || getDefesa() > getVelocidade()) {
            throw new IllegalArgumentException("Defesa deve ser menor ou igual a Ataque e Velocidade.");
        }
	}
}
