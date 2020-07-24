
public class SimpleHeal extends Magia{

	public SimpleHeal(Unit magico) {
		if(usarMagia(magico)) {
			DadosRed dado = new DadosRed();
			int valorDado = dado.roll();
			
			int pontosVida = magico.getPontosVida();
			magico.atualizarPV(pontosVida + valorDado);
		}
	}

}
