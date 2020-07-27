package source.mapa;
import java.util.Random;

public class Armadilha extends Celula{
	private int dano;
	public Armadilha(int x , int y){
		super(x,y);
		Random rng = new Random();
		dano = rng.nextInt(2)+1;
		
	}
	public int getDano() {
		System.out.println("Cuidado onde pisa! Você acaba de cair numa armadilha e receber "+dano+" de dano!");
		return dano;
	}
	
	@Override
	public String toString() {
		return "XX";
	}
}
