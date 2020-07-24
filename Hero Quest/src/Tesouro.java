import java.util.ArrayList;
import java.util.Random;
public class Tesouro extends Celula{
	ArrayList<Item> inside;
	public Tesouro(int x , int y) {
		super(x,y);
		Random rng = new Random();
		if(rng.nextInt(2) == 1) { // dropa arma
			int a = rng.nextInt(3);
			if(a == 0) {
				inside.add(new EspadaCurta());
			}
			else if(a == 1) {
				inside.add(new EspadaLonga());
			}
			else {
				int sz = rng.nextInt(3)+1;
				for(int j = 0 ; j < sz; j ++)
					inside.add(new Punhal());
			}
		}
		else { // dropa magia
			int a = rng.nextInt(4);
			if(a == 0) {
				inside.add(new SimpleHeal());
			}
			else if(a == 1) {
				inside.add(new MagicMissile());
			}
			else if(a == 2) {
				inside.add(new Fireball());
			}
			else {
				inside.add(new Teleport());
			}
		}
	}
	ArrayList<Item> getTesouro(){
		return inside;
	}
}
