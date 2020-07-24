import java.util.ArrayList;

public class Unit extends Celula{
	private int numDadosAtaque;
	private int numDadosDefesa;
	private int pontosVida;
	private int pontosInteligencia;
	//private Armadura armadura;
	private ArrayList<Arma> armas = new ArrayList<Arma>();
	private ArrayList<Magia> magias = new ArrayList<Magia>();
	
	public Unit(int numDadosAtaque, int numDadosDefesa, int pontosVida, int pontosInteligencia, ArrayList<Arma> armas, ArrayList<Magia> magias,int posx , int posy) {
		super(posx, posy);
		this.numDadosAtaque = numDadosAtaque;
		this.numDadosDefesa = numDadosDefesa;
		this.pontosVida = pontosVida;
		this.pontosInteligencia = pontosInteligencia;
		this.armas = armas;
		this.magias = magias;
	}
	
	public void addArma(Arma arma) {
		//LEMBRAR DE MELHORAR ISSO
		if(armas.size() == 2) {
			System.out.println("Você já possui duas armas");
			return;
		}
		this.armas.add(arma);
	}
	
	public void removeArma(Arma arma) {
		//LEMBRAR DE MELHORAR
		if(armas.contains(arma)) {
			this.armas.remove(arma);
		}
		else {
			System.out.println("Você não possui essa arma");
		}
	}
	
	public void addMagia(Magia magia) {
		this.magias.add(magia);
	}
	
	public void removeMagia(Magia magia) {
		if(magias.contains(magia)) {
			this.magias.remove(magia);
		}
		else {
			System.out.println("Você não possui essa arma");
		}
	}
	
	public void usarTeleporte() {
		
	}
	public void usarFireball(Unit enemy) {
		for(Magia cur : magias) {
			if(cur instanceof Fireball) {
				((Fireball) cur).setAlvo(enemy);
				magias.remove(cur);
				break ; 
			}
		}		
	}
	public void usarSimpleHeal() {
		for(Magia cur : magias) {
			if(cur instanceof SimpleHeal) {
				((SimpleHeal) cur).usarMagia();
				magias.remove(cur);
				break ; 
			}
		}
	}
	public void usarMagicMissile(Unit enemy) {
		for(Magia cur : magias) {
			if(cur instanceof MagicMissile) {
				((MagicMissile) cur).setAlvo(enemy);
				magias.remove(cur);
				break ; 
			}
		}
	}
	
	public void combate(Unit enemy) {
		DadosCombat dado = new DadosCombat();
		int qtdCaveira = 0;
		//ataque
		for(int i = 0; i < this.numDadosAtaque; i++) {
			if(dado.ehCaveira()) {
				qtdCaveira ++;
			}
		}
		
		//o inimigo tentará se defender
		int numDados = enemy.getNumDadosDefesa();
		int qtdEscudo = 0;
		for(int i = 0; i < numDados; i++) {
			if(dado.ehEscudo(enemy)) {
				qtdEscudo ++;
			}
		}
		
		int dano = qtdCaveira - qtdEscudo;
		if(dano < 0) dano = 0;
		enemy.diminuirVida(dano);
	}
	//ATUALIZAR PONTOS DE INTELIGENCIA
	public void atualizarPI(int pontosInteligencia) {
		this.pontosInteligencia = pontosInteligencia;
	}
	//ATUALIZAR PONTOS DE VIDA
	public void atualizarPV(int pontosVida) {
		this.pontosVida = pontosVida;
	}
	
	public void atualizarAtaque(int numDadosAtaque) {
		this.numDadosAtaque = numDadosAtaque;
	}
	public void atualizarDefesa(int numDadosDefesa) {
		this.numDadosDefesa = numDadosDefesa;
	}	
	
	public void aumentarVida(int x) {
		this.pontosVida += x;
	}
	public void diminuirVida(int x) {
		this.pontosVida -= x;
		if(this.pontosVida < 0) this.pontosVida = 0;
	}
	
	public int getNumDadosAtaque() {
		return this.numDadosAtaque;
	}
	public int getNumDadosDefesa() {
		return this.numDadosDefesa;
	}
	public int getPontosVida() {
		return this.pontosVida;
	}
	public int getPontosInteligencia() {
		return this.pontosInteligencia;
	}
	
	public ArrayList<Arma> getArmas(){
		return this.armas;
	}
}
