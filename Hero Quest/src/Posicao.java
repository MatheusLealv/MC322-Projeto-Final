import java.util.Random;

public class Posicao{
	private int x; // LINHA
	private int y; // COLUNA
	public Posicao(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void moveUp(Mapa mapa) {
		if(this.x != 0) {
			this.x --;
		}
	}
	public void moveDown(Mapa mapa) {
		int N = mapa.getN();
		if(this.x != N - 1) {
			this.x ++;
		}
	}
	public void moveLeft(Mapa mapa) {
		if(this.y != 0) {
			this.y --;
		}
	}
	public void moveRight(Mapa mapa) {
		int M = mapa.getM();
		if(this.y != M - 1) {
			this.y ++;
		}
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	public void moveRandom(Mapa mapa) {
		Random rng = new Random();
		int direcao = rng.nextInt(4);
		switch(direcao) {
			case 0:
				moveUp(mapa);
				break;
			case 1:
				moveDown(mapa);
				break;
			case 2:
				moveLeft(mapa);
				break;
			case 3:
				moveRight(mapa);
				break;
		}
	}
}
