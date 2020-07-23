import java.util.ArrayList;
import java.util.Random;


public class Esqueleto extends Monstro{
	public Esqueleto() {
		super(1, 1, 3, 1, new ArrayList<Arma>());
		Random rng = new Random();
		int u = rng.nextInt(3) + 1;
		if(u == 1) {
			addArma(new EspadaCurta());
		}
		else if(u == 2) {
			addArma(new EspadaLonga());
		}
		else if(u == 3) {
			addArma(new Punhal());
			addArma(new Punhal());
		}	
	}

}
