
public class Game {

	public static void start() {
		// ------ TESTES -------
		int N = 5, M = 5; // MODIFICAR
		Mapa mapa = new Mapa(N, M);
				
		Heroi heroi = Interaction.criarPersonagem();
		
		//Esqueleto esqueleto = new Esqueleto(0,1);
		//System.out.println(heroi.getNome() + " " + esqueleto.getPontosVida());
				
		mapa.generateMap(heroi);
<<<<<<< HEAD
		System.out.println("DONE\n");
		mapa.monstroTurno();
=======
		mapa.printMap();
		System.out.println("DONE\n");
		mapa.monstroTurno();
		System.out.println("DONE\n");
>>>>>>> 9bf6e7f31e5f2421a84ef3102db8b0805557aaa1
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
