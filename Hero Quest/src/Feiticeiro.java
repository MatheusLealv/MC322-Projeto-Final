import java.util.ArrayList;

public class Feiticeiro extends Heroi implements Magico{

	public Feiticeiro(String nome, int posx, int posy) {
		super(nome, 1, 2, 4, 6 , new ArrayList<Arma>(),posx,posy);
		addArma(new Punhal());
		addArma(new Punhal());
		addArma(new Punhal());
		// adiciona magias
		
	}

}
