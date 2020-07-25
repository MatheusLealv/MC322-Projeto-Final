import java.util.ArrayList;

public class Monstro extends Unit{
	public Monstro(int numDadosAtaque, int numDadosDefesa, int pontosVida, int pontosInteligencia, ArrayList<Arma> armas, ArrayList<Magia> magias, int posx , int posy) {
		super(numDadosAtaque,numDadosDefesa,pontosVida,pontosInteligencia,armas, magias, posx,posy);
		
	}
	
	public void attackHero(Mapa mapa) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for(int i = 0; i < 4; i++) {
			int x = this.getX() + dx[i], y = this.getY() + dy[i];
			if(x >= 0 && x < mapa.getN() && y >= 0 && y < mapa.getM() && (mapa.getCelula(x, y) instanceof Heroi)){
				Heroi heroi = (Heroi)mapa.getCelula(x, y);
				
				if(this instanceof EsqueletoMago) {
					this.usarMagicMissile(heroi);
				}
				else {
					Arma arma = this.getArma();
					this.combate(heroi);
				}

			}
		}
	}
	
	public void death(Mapa mapa) {
		CelulaVazia vazia = new CelulaVazia(x,y);
		mapa.setCelula(x, y, vazia);
	}
}
