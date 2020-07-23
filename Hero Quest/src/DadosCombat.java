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
}
