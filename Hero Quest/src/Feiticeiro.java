import java.util.ArrayList;

public class Feiticeiro extends Heroi implements Magico{

	public Feiticeiro(String nome, int posx, int posy) {
		super(nome, 1, 2, 4, 6 , new ArrayList<Arma>(), new ArrayList<Magia>(), posx,posy);
		addArma(new Punhal());
		addArma(new Punhal());
		addArma(new Punhal());
		
		// adiciona magias
		addMagia(new MagicMissile(this));
		addMagia(new MagicMissile(this));
		addMagia(new MagicMissile(this));
		
		addMagia(new Fireball(this));
		addMagia(new Teleport(this));
		
		setModelo("FE");
	}

}
