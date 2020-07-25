
public class Teleport extends Magia {

	public Teleport(Unit magico) {
		super(magico);
	}
	
	public void usarMagia(Celula C) {
		if((C instanceof CelulaVazia) && this.magico.isVisible(C)) {
			if(this.testarMagia()) {
			//	mapa.swap(this.magico.getX(), this.magico.getY(), C.getX(), C.getY());
			}
			this.magico.removeMagia(this);
		}
		else {
			System.out.println("Não é possível se teleportar para essa célula");
		}
	}
}
