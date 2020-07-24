import java.util.ArrayList;

public class Unit extends Celula{
	private int numDadosAtaque;
	private int numDadosDefesa;
	private int pontosVida;
	private int pontosInteligencia;
	//private Armadura armadura;
	private ArrayList<Arma> armas = new ArrayList<Arma>();
	private ArrayList<Magia> magica = new ArrayList<Magia>();
	
	public Unit(int numDadosAtaque, int numDadosDefesa, int pontosVida, int pontosInteligencia, ArrayList<Arma> armas, ArrayList<Magia> magica,int posx , int posy) {
		super(posx, posy);
		this.numDadosAtaque = numDadosAtaque;
		this.numDadosDefesa = numDadosDefesa;
		this.pontosVida = pontosVida;
		this.pontosInteligencia = pontosInteligencia;
		this.armas = armas;
		this.magica = magica;
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
		this.magica.add(magia);
	}
	
	public void removeMagia(Magia magia) {
		if(magica.contains(magia)) {
			this.magica.remove(magia);
		}
		else {
			System.out.println("Você não possui essa arma");
		}
	}
	
	public void usarTeleporte() {
		
	}
	public void usarFireball(Unit enemy) {
		for(Magia cur : magica) {
			if(cur instanceof Fireball) {
				((Fireball) cur).setAlvo(enemy);
				magica.remove(cur);
				break ; 
			}
		}		
	}
	public void usarSimpleHeal() {
		for(Magia cur : magica) {
			if(cur instanceof SimpleHeal) {
				(())
			}
		}
	}
	public void usarMagicMissile(Unit enemy) {
		for(Magia cur : magica) {
			if(cur instanceof MagicMissile) {
				((MagicMissile) cur).setAlvo(enemy);
				magica.remove(cur);
				break ; 
			}
		}
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
