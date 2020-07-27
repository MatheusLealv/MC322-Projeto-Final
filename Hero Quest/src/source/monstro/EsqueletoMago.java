package source.monstro;
import java.util.ArrayList;

import source.items.Arma;
import source.magia.Magia;
import source.magia.MagicMissile;
import source.magia.Magico;
import source.mapa.Mapa;


public class EsqueletoMago extends Monstro implements Magico{
	public EsqueletoMago(int posx , int posy) {
		super(1, 1, 3, 5, new ArrayList<Arma>(), new ArrayList<Magia>(), posx,posy);
		
		// adicionar magia
		addMagia(new MagicMissile(this));
		addMagia(new MagicMissile(this));
		
	}
	
	public void makeTurn(Mapa mapa) {
		mapa.moveRandom(this);
		this.attackHero(mapa);
	}
	
	@Override
	public String toString() {
		return "EM";
	}	
	
	@Override
	public String getNome() {
		return "Esqueleto Mago";
	}
}
