package source.heroi;
import java.util.ArrayList;

import source.items.Arma;
import source.items.EspadaLonga;
import source.magia.Magia;

public class Barbaro extends Heroi{

	public Barbaro(String nome, int posx , int posy) {
		super(nome, 3, 2, 8, 2, new ArrayList<Arma>(), new ArrayList<Magia>(), posx,posy);
		addArma(new EspadaLonga());
	}
	@Override
	public String toString() {
		return "BA";
	}
	
}
