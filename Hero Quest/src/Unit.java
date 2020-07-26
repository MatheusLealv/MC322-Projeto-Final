import java.util.ArrayList;
import java.util.Scanner;

public class Unit extends Celula{
	private int numDadosAtaque;
	private int numDadosDefesa;
	private int pontosVida;
	private int pontosInteligencia;
	protected ArrayList<Arma> armas = new ArrayList<Arma>();
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
		int slot = 0;
		for(int i = 0 ; i < armas.size() ; i ++) {
			slot += armas.get(i).getSize() ; 
		}
		if(!(arma instanceof Punhal)) {
			if((slot + arma.getSize()) > 2) {
				System.out.println("Você não tem mãos suficientes para usar ambas as armas , suas armas atuais serão perdidas caso equipe a arma.");
				System.out.println("Tem certeza que deseja equipar a arma? (1 = yes/0 = no)");
				Scanner read = new Scanner(System.in);
				int cls;
				while(true) {
					try {
						cls = read.nextInt();
						break;
					} catch(Exception e) {
						System.out.println("Por favor digite um número");
					}
				}
				if(cls == 1) {
					ArrayList<Arma> newArmas = new ArrayList<Arma>();
					for(int j = 0 ; j < armas.size(); j ++) {
						newArmas.add(armas.get(j));
						if(!(armas.get(j) instanceof Punhal)) {
							this.numDadosAtaque -= armas.get(j).getBonusDado();
						}
					}
					newArmas.add(arma);
					this.armas = newArmas;
					this.numDadosAtaque += arma.getBonusDado();
				}
			}
			else {
				this.armas.add(arma);
				this.numDadosAtaque += arma.getBonusDado();
			}
		}
		else {
			armas.add(arma);
		}
	}
	
	public void removeArma(Arma arma) {
		//LEMBRAR DE MELHORAR
		if(! (arma instanceof Punhal)) {
			if(armas.contains(arma)) {
				this.armas.remove(arma);
				this.numDadosAtaque -= arma.getBonusDado();
			}
			else {
				System.out.println("Você não possui essa arma");
			}
		}
		else {
			armas.remove(arma);
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
			System.out.println("Você não possui essa magia");
		}
	}
	
	public void usarTeleporte(Mapa mapa, Celula C) {
		for(Magia cur: magias) {
			if(cur instanceof Teleport) {
				((Teleport) cur).usarMagia(mapa, C);
				magias.remove(cur);
				return;
			}
		}
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
	
	public void combate(Mapa mapa,Unit enemy, ArrayList<Arma> armas) {
		DadosCombat dado = new DadosCombat();
		ArrayList<Arma> armasUsadas = new ArrayList<Arma>();
		int dadosAtaque = this.numDadosAtaque;
		int qtdCaveira = 0;
		if( Math.abs(this.getY() - enemy.getY()) + Math.abs(this.getY() - enemy.getX()) <= 1) {
			qtdCaveira = this.getNumDadosAtaque();
		}
		this.getNumDadosAtaque();
		for(Arma arma: armas) {
			if(Math.abs(this.getX() - enemy.getX()) + Math.abs(this.getY() - enemy.getY()) <= arma.getAlcance()) {
				dadosAtaque+=arma.getBonusDado();
				armasUsadas.add(arma);
			}
		}
		if(this instanceof Heroi) {
			//ataque
			for(int i = 0; i < dadosAtaque; i++) {
				if(dado.ehCaveira()) {
					qtdCaveira ++;
				}
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
		
		if(enemy.getPontosVida()<=0) {
			enemy.death(mapa);
		}

		for(Arma arma: armasUsadas) {

			if(arma.ehDestruida()) {
				this.removeArma(arma);
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
	
	public boolean temEspadaLonga() {
		for(Arma arma: armas) {
			if(arma instanceof EspadaLonga) {
				return true;
			}
		}
		return false;
	}
	public void aumentarVida(int x) {
		this.pontosVida += x;
	}
	public void diminuirVida(int dano) {
		this.pontosVida -= dano;
		System.out.println(this.getNome()+" recebeu "+dano+" de dano.");
		if(this.pontosVida < 0) this.pontosVida = 0;
	}
	
	public void danoDireto(int dano) {
		this.pontosVida -= dano;
		System.out.println(this.getNome()+" recebeu "+dano+" de dano.");
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
	public ArrayList<Magia> getMagias(){
		return this.magias;
	}
	
	public Arma getArma() {
		if(this.getArmas().isEmpty()) {
			return null;
		}
		return this.getArmas().get(0);
	}
	
	public Magia getMagia() {
		if(this.getMagias().isEmpty()) {
			return null;
		}
		return this.getMagias().get(0);
	}
	
	public void death(Mapa mapa) {}
	
	public String getNome() {return "";} 
}
