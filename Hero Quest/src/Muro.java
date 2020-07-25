public class Muro extends Celula implements Bloqueado{

	public Muro(int posx , int posy) {
		super(posx , posy);
		
		this.setModelo("##");
	}
	
}
