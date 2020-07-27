package source.heroi;
import java.util.ArrayList;

import source.items.Arma;
import source.items.EspadaCurta;
import source.magia.Magia;
import source.magia.Magico;
import source.magia.SimpleHeal;

public class Elfo extends Heroi implements Magico{
	
	public Elfo(String nome, int posx, int posy) {
		super(nome, 2, 2, 6, 4 , new ArrayList<Arma>(), new ArrayList<Magia>(), posx, posy);
		addArma(new EspadaCurta());
		addMagia(new SimpleHeal(this));
	}
	@Override
	public String toString() {
		return "EL";
	}
}
