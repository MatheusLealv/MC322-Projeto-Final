import java.util.ArrayList;

public class Anao extends Heroi{

	public Anao(String nome){
		super(nome, 2, 2, 7, 3, new ArrayList<Arma>());
		addArma(new EspadaCurta());
	}
	
	

}
