package source.items;

public class Armadura implements Dropavel{
	private int defesa;
	
	public Armadura(int defesa) {
		this.defesa = defesa;
	}
	
	public void updateDefesa(int defesa){
		this.defesa = defesa;
	}
	public int getDefesa() {
		return this.defesa;
	}
	
	
}
