
public class Arma extends Item{
	private int bonusDados;
	private int alcance;
	private boolean ehDestruida;
	public Arma(int bonusDado, int alcance, boolean ehDestruida) {
		this.alcance = alcance;
		this.bonusDados = bonusDado;
		this.ehDestruida = ehDestruida;
	}
	
	public int getBonusDado() {
		return this.bonusDados;
	}
	public int getAlcance() {
		return this.alcance;
	}
	public boolean ehDestruida() {
		return this.ehDestruida;
	}
}
