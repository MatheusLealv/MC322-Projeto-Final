import java.util.ArrayList;

public class Sala {
	private ArrayList<Tesouro> tesouros = new ArrayList<Tesouro>();
	private ArrayList<Armadilha> armadilhas = new ArrayList<Armadilha>();
	private ArrayList<Monstro> monstros = new ArrayList<Monstro>();
	
	public Sala(ArrayList<Tesouro> tesouros, ArrayList<Armadilha> armadilhas, ArrayList<Monstro> monstros) {
		this.tesouros = tesouros;
		this.armadilhas = armadilhas;
		this.monstros = monstros;
	}
	
	public ArrayList<Tesouro> getTesouros(){
		return this.tesouros;
	}
	public ArrayList<Armadilha> getArmadilhas(){
		return this.armadilhas;
	}
	public ArrayList<Monstro> getMonstros(){
		return this.monstros;
	}
}
