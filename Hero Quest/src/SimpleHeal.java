
public class SimpleHeal extends Magia{
	public SimpleHeal(Unit magico) {
		super(magico);
	}
	
	public void usarMagia() {
		if(testarMagia(this.getMagico())) {
			DadosRed dado = new DadosRed();
			int valorDado = dado.roll();
			
			int pontosVida = this.getMagico().getPontosVida();
			this.getMagico().atualizarPV(pontosVida + valorDado);
		}
	}

}
