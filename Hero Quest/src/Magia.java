
public class Magia implements Item{
	protected Unit magico;
	public Magia(Unit magico) {
		this.magico=magico;
	}
	
	public Unit getMagico() {
		return magico;
	}
	// MAGICO TENTA ATACAR O ALVO
	// RETORNA TRUE se magico consegue atacar o alvo
	public boolean testarMagia() {
		if(this.magico instanceof Magico) {
			DadosRed dado = new DadosRed();
			int valorDado = dado.roll();
			
			if(valorDado <= this.magico.getPontosVida()) {
				return true;
			}
		}
		else {
			System.out.println("Esta Unidade não eh magica");
		}
		
		return false;
	}
	
	//O ALVO VAI TENTAR SE DEFENDER
	//Retorna true se o alvo nao consegue se defender
	public int defenderMagia(Unit alvo) {
		int qtdDados = alvo.getPontosInteligencia();
		int qtdEscudo = 0;
		for(int i = 0; i < qtdDados; i++) {
			DadosCombat dado = new DadosCombat();
			if(dado.ehEscudo(alvo)) {
				qtdEscudo ++;
			}
		}
		return qtdEscudo;
	}
}
