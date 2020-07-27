package source.magia;

import source.Unit;
import source.utilities.DadosRed;

public class SimpleHeal extends Magia implements MagiaHeal{
	public SimpleHeal(Unit magico) {
		super(magico);
	}
	
	public void usarMagia() {
		if(testarMagia()) {
			DadosRed dado = new DadosRed();
			int valorDado = dado.roll();
			
			this.getMagico().aumentarVida(valorDado);
		}
		
		this.magico.removeMagia(this);
	}
	@Override
	public String toString() {
		return "Simple Heal";
	}
}
