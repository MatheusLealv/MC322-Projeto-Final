
public class Magia {
	
	// MAGICO TENTA ATACAR O ALVO
	// RETORNA TRUE se magico consegue atacar o alvo
	public boolean usarMagia(Unit magico) {
		if(magico instanceof Magico) {
			DadosRed dado = new DadosRed();
			int valorDado = dado.roll();
			
			if(valorDado <= magico.getPontosVida()) {
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
	public boolean defenderAtaque(Unit magico, Unit alvo) {
		int qtdDados = alvo.getPontosInteligencia();
		for(int i = 0; i < qtdDados; i++) {
			DadosCombat dado = new DadosCombat();
			int valorDado = dado.roll();
			
			if((alvo instanceof Heroi) && (valorDado != 1)) {
				return false;
			}
			
			if((alvo instanceof Monstro) && valorDado != 2) {
				return false;
			}
		}
		return true;
	}
}
