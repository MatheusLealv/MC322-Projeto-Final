import java.util.ArrayList;
import java.util.Random;


public class EsqueletoMago extends Monstro implements Magico{
	public EsqueletoMago(int posx , int posy) {
		super(1, 1, 3, 5, new ArrayList<Arma>(), new ArrayList<Magia>(), posx,posy);
		// adicionar Punhos
		
		// adicionar magia
		addMagia(new MagicMissile(this));
	}
	
}
