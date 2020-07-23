import java.util.Random;

public class DadosCombat implements Dados {
	public int roll() {
		Random rng = new Random();
		return rng.nextInt(6) + 1;
	}
}
