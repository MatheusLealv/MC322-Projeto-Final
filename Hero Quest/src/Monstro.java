import java.util.ArrayList;

public class Monstro extends Unit implements Dropavel{
	public Monstro(int numDadosAtaque, int numDadosDefesa, int pontosVida, int pontosInteligencia, ArrayList<Arma> armas, ArrayList<Magia> magias, int posx , int posy) {
		super(numDadosAtaque,numDadosDefesa,pontosVida,pontosInteligencia,armas, magias, posx,posy);
		
	}
	
	public void attackHero(Mapa mapa){
		
		Heroi heroi = mapa.getHeroi();
		this.combate(mapa, heroi, this.armas);
	}
	@Override
	public void death(Mapa mapa) {
		CelulaVazia vazia = new CelulaVazia(x,y);
		mapa.setCelula(x, y, vazia);
	}
}
