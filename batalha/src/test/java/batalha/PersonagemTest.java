package batalha;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PersonagemTest {
	
	@Test
	void testeChecarTotalIgualA20_NaoLancaExcecao() {
		Personagem p = new Personagem() {
			@Override
			void checarRegraDeClasse() {
				// Deixado em branco de propósito
			}
		};
		
		Integer ataque = 7;
		Integer defesa = 6;
		Integer velocidade = 4;
		Integer resistencia = 3;
		
		p.setAtaque(ataque);
		p.setDefesa(defesa);
		p.setResistencia(resistencia);
		p.setVelocidade(velocidade);
		
		assertDoesNotThrow(()->p.checarTotal());
	}
	
	@Test
	void testeChecarTotalIgualA19_LancaExcecao() {
		Personagem p = new Personagem() {
			@Override
			void checarRegraDeClasse() {
				// Deixado em branco de propósito
			}
		};
		
		Integer ataque = 7;
		Integer defesa = 5;
		Integer velocidade = 4;
		Integer resistencia = 3;
		
		p.setAtaque(ataque);
		p.setDefesa(defesa);
		p.setResistencia(resistencia);
		p.setVelocidade(velocidade);
		
		assertThrows(IllegalStateException.class, ()->p.checarTotal());
	}
	
	@Test
	void testeChecarTotalIgualA21_LancaExcecao() {
		Personagem p = new Personagem() {
			@Override
			void checarRegraDeClasse() {
				// Deixado em branco de propósito
			}
		};
		
		Integer ataque = 9;
		Integer defesa = 5;
		Integer velocidade = 4;
		Integer resistencia = 3;
		
		p.setAtaque(ataque);
		p.setDefesa(defesa);
		p.setResistencia(resistencia);
		p.setVelocidade(velocidade);
		
		assertThrows(IllegalStateException.class, ()->p.checarTotal());
	}
}
