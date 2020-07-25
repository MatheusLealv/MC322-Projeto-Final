
public class Main {

	//APENAS PARA TESTAR SE NAO RTE 
	//MODIFICAR TUDO DEPOIS
	public static void main(String[] args) {
		
		// ------ TESTES -------
		int N = 5, M = 5; // MODIFICAR
		Mapa mapa = new Mapa(N, M);
		
		Heroi heroi = new Barbaro("joao", 0, 0);
		//Esqueleto esqueleto = new Esqueleto(0,1);
		//System.out.println(heroi.getNome() + " " + esqueleto.getPontosVida());
		
		mapa.generateMap(heroi);
		System.out.println("DONE\n");
		
		mapa.printMap();
	}

}
