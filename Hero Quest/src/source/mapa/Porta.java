package source.mapa;

public class Porta extends Celula implements Bloqueado{

	public Porta(int posx, int posy) {
		super(posx,posy);
	}
	
	public void abrir(Mapa mapa) {
		int x = this.getX(), y = this.getY();
		Celula nova = new CelulaVazia(x, y);
		mapa.setCelula(x, y, nova);
	}
	
	@Override
	public String toString() {
		return "PP";
	}	

}
