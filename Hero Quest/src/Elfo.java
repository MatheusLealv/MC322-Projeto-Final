import java.util.ArrayList;

public class Elfo extends Heroi implements Magico{

	public Elfo(String nome) {
		super(nome, 2, 2, 6, 4 , new ArrayList<Arma>());
		addArma(new EspadaCurta());
	}

}
