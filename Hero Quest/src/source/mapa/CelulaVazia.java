package source.mapa;

public class CelulaVazia extends Celula{
	
	public CelulaVazia(int posx , int posy) {
		super(posx , posy);
		
	}
	@Override
	public String toString() {
		return "..";
	}
}
