
public class SimpleHeal extends Magia{

	public SimpleHeal(Unit magico) {
		if(magico instanceof Magico) {
			if(usarMagia(magico)) {
				DadosRed dado = new DadosRed();
				int valorDado = dado.roll();
				
				int pontosVida = magico.getPontosVida();
				magico.atualizarPV(pontosVida + valorDado);
			}
		}
		else{
			System.out.println("Esta Unidade não eh magica");		
		}
	}

}
