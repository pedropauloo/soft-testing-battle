package batalha;

public class Guerreiro extends Personagem {

    public Guerreiro(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia) {
        super(ataque, defesa, velocidade, resistencia);
    }

    public Guerreiro(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia, String jogador) {
        super(ataque, defesa, velocidade, resistencia, jogador);
    }

    @Override
    final void checarRegraDeClasse() throws IllegalArgumentException {
        if (getAtaque() < getResistencia()) {
            throw new IllegalArgumentException("Ataque deve ser maior ou igual à Resistencia.");
        }
        if (getResistencia() < getAtaque()) {
            throw new IllegalArgumentException("Resistencia deve ser maior ou igual ao Ataque.");
        }
        if (getVelocidade() > getAtaque() || getVelocidade() > getResistencia()) {
            throw new IllegalArgumentException("Velocidade deve ser menor ou igual a Ataque e Resistencia.");
        }
        if (getDefesa() > getAtaque() || getDefesa() > getResistencia()) {
            throw new IllegalArgumentException("Defesa deve ser menor ou igual a Ataque e Resistencia.");
        }
    }
}