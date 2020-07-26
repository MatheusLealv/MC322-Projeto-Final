//Personagem Secreto
import java.util.*;
public class Kirito extends Heroi implements Magico {

	public Kirito(String nome,int posx,int posy) {
		super(nome,8,5,10,6,new ArrayList<Arma>(),new ArrayList<Magia>(),posx,posy);
		addArma(new EspadaCurta());
		addArma(new EspadaCurta());
		addMagia(new SimpleHeal(this));
		addMagia(new MagicMissile(this));
		addMagia(new Fireball(this));
		addMagia(new Teleport(this));
	}
	
	@Override
	public String toString() {
		return "KI";
	}
}
