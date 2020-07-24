
public class MagicMissile extends Magia{
	private Unit alvo;
	
	public MagicMissile(Unit magico) {
		super(magico);
	}
	
	public void setAlvo(Unit alvo) {
		this.alvo = alvo;
	}
	
	public void usar() {
		if(usarMagia(this.getMagico())) {
			alvo.diminuirVida(6);
		}
	}

}
