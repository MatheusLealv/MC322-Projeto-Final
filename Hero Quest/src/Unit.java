import java.util.ArrayList;

public class Unit {
	private int numDadosAtaque;
	private int numDadosDefesa;
	private int pontosVida;
	private int pontosInteligencia;
	
	//private Armadura armadura;
	private ArrayList<Arma> armas = new ArrayList<Arma>();
	
	public Unit(int numDadosAtaque, int numDadosDefesa, int pontosVida, int pontosInteligencia, ArrayList<Arma> armas) {
		//this.nome = nome;
		this.numDadosAtaque = numDadosAtaque;
		this.numDadosDefesa = numDadosDefesa;
		this.pontosVida = pontosVida;
		this.pontosInteligencia = pontosInteligencia;
		this.armas = armas;
		
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
