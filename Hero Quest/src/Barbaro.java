import java.util.ArrayList;

public class Barbaro extends Heroi{

	public Barbaro(String nome) {
		super(nome, 3, 2, 8, 2, new ArrayList<Arma>());
		addArma(new EspadaLonga(0));
	}
	
}
