import java.util.Random;

public class Armadilha extends Celula{
	private int dano;
	public Armadilha(int x , int y){
		super(x,y);
		Random rng = new Random();
		dano = rng.nextInt(2)+1;
		
		this.setModelo("XX");
	}
	public int getDano() {
		return dano;
	}
}
