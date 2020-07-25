import java.util.ArrayList;
import java.util.Random;


public class Esqueleto extends Monstro{
	public Esqueleto(int posx, int posy) {
		super(2, 1, 3, 1, new ArrayList<Arma>(), new ArrayList<Magia>(), posx, posy);
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
	
	public void makeTurn(Mapa mapa) {
		mapa.moveRandom(this);
		this.attackHero(mapa);
	}
	
	@Override
	public String toString() {
		return "ES";
	}

}
