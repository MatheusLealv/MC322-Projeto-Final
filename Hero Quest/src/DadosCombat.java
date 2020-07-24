import java.util.Random;

public class DadosCombat implements Dados {
	public int roll() {
		Random rng = new Random();
		int u = rng.nextInt(6) + 1;
		if(u <= 3) {
			return 0; // Caveira
		}
		else if(u < 6) {
			return 1; // Escudo do heroi
		}
		else {
			return 2; // Escudo do monstro
		}
	}
	
	public boolean ehCaveira() {
		int valorDado = roll();
		if(valorDado == 0) {
			return true;
		}
		return false;
	}
	
	public boolean ehEscudo(Unit unit) {
		int valorDado = roll();
		if(unit instanceof Heroi) {
			if(valorDado == 1) {
				return true;
			}
			return false;
		}
		else {
			if(valorDado == 2) {
				return true;
			}
			return false;
		}
	}
	
}
