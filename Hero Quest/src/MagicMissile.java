
public class MagicMissile extends Magia{
	private Unit alvo;
	
	public MagicMissile(Unit magico) {
		super(magico);
	}
	
	public void setAlvo(Unit alvo) {
		this.alvo = alvo;
	}
	
	public void usarMagia() {
<<<<<<< HEAD
		if(testarMagia(this.getMagico()) && defenderAtaque(alvo)) {
			alvo.diminuirVida(6);
=======
		if(usarMagia(this.getMagico())) {
			for(int i=0;i<3;i++) 
				if(defenderAtaque(alvo)) {
					alvo.diminuirVida(2);
				}
>>>>>>> b87381f2a65d8ee1a8f595f702dac802ea9ed241
		}
	}

}
