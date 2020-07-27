package source.magia;

import source.Unit;

public class MagicMissile extends Magia implements MagiaAtaque , MagiaSingle{
	private Unit alvo;
	
	public MagicMissile(Unit magico) {
		super(magico);
	}
	
	public void setAlvo(Unit alvo) {
		this.alvo = alvo;
	}
	
	public void usarMagia() {
		if(testarMagia()) {
			for(int i=0;i<3;i++) {
				int dano = 2 - this.defenderMagia(alvo);
				if(dano < 0) {
					dano = 0;
				}
				alvo.danoDireto(dano);
			}
		}
		
		this.magico.removeMagia(this);
	}
	@Override
	public String toString() {
		return "Missile";
	}
}
