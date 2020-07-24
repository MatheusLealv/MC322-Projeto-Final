import java.util.ArrayList;

public class Elfo extends Heroi implements Magico{
	
	public Elfo(String nome, int posx, int posy) {
		super(nome, 2, 2, 6, 4 , new ArrayList<Arma>(), new ArrayList<Magia>(), posx, posy);
		addArma(new EspadaCurta());
		addMagia(new SimpleHeal(this));
	}

}
