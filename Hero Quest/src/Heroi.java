import java.util.*;

public class Heroi extends Unit {
	private String nome;
	
	private Armadura armadura;
	
	public Heroi(String nome, int numDadosAtaque, int numDadosDefesa, int pontosVida, int pontosInteligencia, ArrayList<Arma> armas,ArrayList<Magia> magias, int posx,int posy) {
		super(numDadosAtaque,numDadosDefesa,pontosVida,pontosInteligencia,armas, magias, posx,posy);
		this.nome = nome;

		this.armadura = new Armadura(0);
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
	
	public void tomarArmadilha(Armadilha armadilha) {
		danoDireto(armadilha.getDano());
	}
	
	public void procurarTesouro(Celula C) {
		//PODE ENCONTRAR UM MONSTRO
		//O QUE FAZER QUANDO ENCONTRAR UM MONSTRO ?
		if(C instanceof Monstro) {
			
		}
		
		if(C instanceof Tesouro) {
			Tesouro tesouro = (Tesouro)(C);
			tesouro.getTesouro(this);
			
			C = new CelulaVazia(C.getX(), C.getY());
		}
	}
	
	public void moveUp(Mapa mapa) {
		if(this.x == 0) {
			return;
		}
		mapa.trocaCel(this.x, this.y, this.x - 1, this.y);
	}
	
	public void moveDown(Mapa mapa) {
		if(this.x == mapa.getN() - 1) {
			return;
		}
		Celula to = mapa.getCelula(this.x + 1, this.y);
		if(to instanceof Armadilha) {
			tomarArmadilha((Armadilha)to);
			to = new CelulaVazia(to.getX(), to.getY());
		}
		mapa.trocaCel(this.x, this.y, this.x + 1, this.y);
	}
	
	public void moveLeft(Mapa mapa) {
		if(this.y == 0) {
			return;
		}
		Celula to = mapa.getCelula(this.x, this.y - 1);
		if(to instanceof Armadilha) {
			tomarArmadilha((Armadilha)to);
			to = new CelulaVazia(to.getX(), to.getY());
		}
		mapa.trocaCel(this.x, this.y, this.x, this.y - 1);
	}
	
	public void moveRight(Mapa mapa) {
		if(this.y == mapa.getM() - 1) {
			return;
		}
		Celula to = mapa.getCelula(this.x, this.y + 1);
		if(to instanceof Armadilha) {
			tomarArmadilha((Armadilha)to);
			to = new CelulaVazia(to.getX(), to.getY());
		}
		mapa.trocaCel(this.x, this.y, this.x, this.y + 1);
	}
	
	
}
