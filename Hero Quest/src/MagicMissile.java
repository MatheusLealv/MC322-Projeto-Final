
public class MagicMissile extends Magia{
	private Unit alvo;
	
	public MagicMissile(Unit magico) {
		super(magico);
	}
	
	public void setAlvo(Unit alvo) {
		this.alvo = alvo;
	}
	
	public void usarMagia() {
		if(usarMagia(this.getMagico()) && defenderAtaque(alvo)) {
			alvo.diminuirVida(6);
		}
	}

}
