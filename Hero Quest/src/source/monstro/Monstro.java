package source.monstro;
import java.util.ArrayList;

import source.Unit;
import source.heroi.Heroi;
import source.items.Arma;
import source.items.Dropavel;
import source.magia.Magia;
import source.mapa.CelulaVazia;
import source.mapa.Mapa;

public class Monstro extends Unit implements Dropavel{
	public Monstro(int numDadosAtaque, int numDadosDefesa, int pontosVida, int pontosInteligencia, ArrayList<Arma> armas, ArrayList<Magia> magias, int posx , int posy) {
		super(numDadosAtaque,numDadosDefesa,pontosVida,pontosInteligencia,armas, magias, posx,posy);
		
	}
	
	public void attackHero(Mapa mapa){
		Heroi heroi = mapa.getHeroi();
		if(!heroi.isAlive()) return;
		this.combate(mapa, heroi, this.armas);
	}
	@Override
	public void death(Mapa mapa) {
		mapa.diminuiMonstros();
		CelulaVazia vazia = new CelulaVazia(x,y);
		mapa.setCelula(x, y, vazia);
	}
}
