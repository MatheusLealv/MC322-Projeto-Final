import java.util.ArrayList;

public class Anao extends Heroi{

	public Anao(String nome,int posx, int posy){
		super(nome, 2, 2, 7, 3, new ArrayList<Arma>(),posx,posy);
		addArma(new EspadaCurta());
	}
	
	

}
