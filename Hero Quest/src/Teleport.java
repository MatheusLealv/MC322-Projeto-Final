
public class Teleport extends Magia implements MagiaTeleporte {

	public Teleport(Unit magico) {
		super(magico);
	}
	
	public void usarMagia(Mapa mapa, Celula C) {
		if((C instanceof CelulaVazia) && this.magico.isVisible(mapa, C)) {
			if(this.testarMagia()) {
				mapa.trocaCel(this.magico.getX(), this.magico.getY(), C.getX(), C.getY());
			}
			this.magico.removeMagia(this);
		}
		else {
			System.out.println("Não é possível se teleportar para essa célula");
		}
	}
	
	@Override
	public String toString() {
		return "Teleporte";
	}
}
