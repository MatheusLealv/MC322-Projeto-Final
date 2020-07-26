import java.util.ArrayList;
import java.util.Random;


public class Goblin extends Monstro{
	public Goblin(int posx , int posy) {
		super(4, 1, 3, 2, new ArrayList<Arma>(), new ArrayList<Magia>(), posx, posy);
		Random rng = new Random();
		int u = rng.nextInt(3) + 1;
		for(int j = 0 ; j < u ; j ++) 
			addArma(new Punhal());
		
	}
	
	public void makeTurn(Mapa mapa, Heroi hero) {
		Pair u = mapa.moveToHero(this, hero);
		this.attackHero(mapa);
	}
	
	@Override
	public String toString() {
		return "GO";
	}
	
	@Override
	public String getNome() {
		return "Goblin";
	}
}
