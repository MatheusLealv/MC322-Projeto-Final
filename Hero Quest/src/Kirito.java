//Personagem Secreto
import java.util.*;
public class Kirito extends Heroi implements Magico {

	public Kirito(String nome,int posx,int posy) {
		super(nome,8,5,10,6,new ArrayList<Arma>(),new ArrayList<Magia>(),posx,posy);
		addArma(new EspadaCurta());
		addArma(new EspadaCurta());
	}
	
	@Override
	public String toString() {
		return "KI";
	}
}
