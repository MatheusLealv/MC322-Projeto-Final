
public class Fireball extends Magia{
	Unit alvo;
	public Fireball(Unit magico) {
		super(magico);
	}
	public void setAlvo(Unit alvo) {
		this.alvo = alvo;
	}
	
	public void usarMagia(Mapa mapa) {
		int x = this.alvo.getX();
		int y = this.alvo.getY();
		int N = mapa.getN();
		int M = mapa.getM();
		
		int[] dx = {1, -1, 0, 0, 0};
		int[] dy = {0, 0, 1, -1, 0};
		for(int i = 0; i < 5; i++) {
			int xi = x + dx[i];
			int yi = y + dy[i];
			
			if(0 <= xi && xi < N && 0 <= yi && yi < M) {
				Celula C = mapa.getCelula(xi, yi);
				if(C instanceof Unit) {
					((Unit) C).danoDireto(6);
				}
			}
		}
		
		this.magico.removeMagia(this);
	}
}
