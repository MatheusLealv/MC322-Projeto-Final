
public class SimpleHeal extends Magia{
	Unit magico;
	public SimpleHeal(Unit magico) {
		this.magico = magico;
	}
	
	public void usarMagia() {
		if(usarMagia(magico)) {
			DadosRed dado = new DadosRed();
			int valorDado = dado.roll();
			
			int pontosVida = magico.getPontosVida();
			magico.atualizarPV(pontosVida + valorDado);
		}
	}

}
