import java.util.*;

public class Heroi extends Unit {
	private String nome;
	
	private Armadura armadura;
	
	public Heroi(String nome, int numDadosAtaque, int numDadosDefesa, int pontosVida, int pontosInteligencia, ArrayList<Arma> armas,ArrayList<Magia> magias, int posx,int posy) {
		super(numDadosAtaque,numDadosDefesa,pontosVida,pontosInteligencia,armas, magias, posx,posy);
		this.nome = nome;
		this.armadura = new Armadura(1);
	}
	public String getNome() {
		return this.nome;
	}
	public void diminuirVida(int x) {
		this.atualizarPV(this.getPontosVida() - Math.max(0,x-this.armadura.getDefesa()));
	}
	public void atualizarArmadura(Armadura armadura) {
		this.armadura = armadura;
	}

}
