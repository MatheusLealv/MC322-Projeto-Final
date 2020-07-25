
public class Game {

	public static void start() {
		// ------ TESTES -------
		int N = 5, M = 5; // MODIFICAR
		Mapa mapa = new Mapa(N, M);
				
		Heroi heroi = Interaction.criarPersonagem();
		
		//Esqueleto esqueleto = new Esqueleto(0,1);
		//System.out.println(heroi.getNome() + " " + esqueleto.getPontosVida());
				
		mapa.generateMap(heroi);
		mapa.printMap();
		System.out.println("DONE\n");
		
		
		
//		heroi.moveRight(mapa);
//		mapa.printMap();
//		
//		System.out.print("\n");
//		heroi.moveDown(mapa);
//		mapa.printMap();
//		
//		System.out.println("");
//		
//		System.out.println("PONTOS DE VIDA: " + heroi.getPontosVida());
	}

}
