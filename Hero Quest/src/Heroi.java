import java.util.ArrayList;

public class Heroi extends Unit {
	private String nome;
	
	private Armadura armadura;
	
	public Heroi(String nome, int numDadosAtaque, int numDadosDefesa, int pontosVida, int pontosInteligencia, ArrayList<Arma> armas,int posx,int posy) {
		super(numDadosAtaque,numDadosDefesa,pontosVida,pontosInteligencia,armas,posx,posy);
		this.nome = nome;
		this.armadura = new Armadura(0);
	}
	public String getNome() {
		return this.nome;
	}
	public void atualizarArmadura(Armadura armadura) {
		this.armadura = armadura;
	}

}
