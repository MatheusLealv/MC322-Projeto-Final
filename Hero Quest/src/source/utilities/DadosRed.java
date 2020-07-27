package source.utilities;
import java.util.Random;

public class DadosRed implements Dados{
	public int roll() {
		Random rng = new Random();
		return rng.nextInt(6) + 1;
	}
}
