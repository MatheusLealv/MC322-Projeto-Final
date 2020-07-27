package source.heroi;
import java.util.ArrayList;

import source.items.Arma;
import source.items.EspadaCurta;
import source.magia.Magia;

public class Anao extends Heroi{

	public Anao(String nome,int posx, int posy){
		super(nome, 2, 2, 7, 3, new ArrayList<Arma>(), new ArrayList<Magia>(), posx,posy);
		addArma(new EspadaCurta());
		
	}	
	@Override
	public String toString() {
		return "AN";
	}
}
