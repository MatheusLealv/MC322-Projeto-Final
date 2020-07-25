import java.util.ArrayList;

public class Barbaro extends Heroi{

	public Barbaro(String nome, int posx , int posy) {
		super(nome, 3, 2, 8, 2, new ArrayList<Arma>(), new ArrayList<Magia>(), posx,posy);
		addArma(new EspadaLonga());
		
		setModelo("BA");
	}
	
	
}
