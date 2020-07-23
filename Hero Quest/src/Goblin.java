import java.util.ArrayList;
import java.util.Random;


public class Goblin extends Monstro{
	public Goblin() {
		super(3, 1, 3, 2, new ArrayList<Arma>());
		Random rng = new Random();
		int u = rng.nextInt(3) + 1;
		for(int j = 0 ; j < u ; j ++) 
			addArma(new Punhal());
		
	}
	
}
