import java.util.ArrayList;

public class Feiticeiro extends Heroi{

	public Feiticeiro(String nome) {
		super(nome, 1, 2, 4, 6 , new ArrayList<Arma>());
		addArma(new Punhal());
		addArma(new Punhal());
		addArma(new Punhal());
		// adiciona magias
		
	}

}
