
public class MagicMissile extends Magia{
	private Unit alvo;
	
	public MagicMissile(Unit magico) {
		super(magico);
	}
	
	public void setAlvo(Unit alvo) {
		this.alvo = alvo;
	}
	
	public void usarMagia() {
		if(testarMagia(this.getMagico())) {
			for(int i=0;i<3;i++) 
				if(defenderAtaque(alvo)) {
					alvo.diminuirVida(2);
				}
		}
	}

}
