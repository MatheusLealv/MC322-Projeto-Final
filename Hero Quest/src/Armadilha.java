import java.util.Random;

public class Armadilha extends Celula{
	private int dano;
	public Armadilha(int x , int y){
		super(x,y);
		Random rng = new Random();
		dano = rng.nextInt(3)+1;
	}
	public int getDano() {
		return dano;
	}
}
