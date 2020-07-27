package source.items;

public class Arma implements Dropavel{
	private int bonusDados;
	private int alcance;
	private int size;
	private boolean ehDestruida;
	public Arma(int bonusDado, int alcance, boolean ehDestruida , int size) {
		this.alcance = alcance;
		this.bonusDados = bonusDado;
		this.ehDestruida = ehDestruida;
		this.size = size;
	}
	public int getBonusDado() {
		return this.bonusDados;
	}
	public int getSize() {
		return size;
	}
	public int getAlcance() {
		return this.alcance;
	}
	public boolean ehDestruida() {
		return this.ehDestruida;
	}
}
