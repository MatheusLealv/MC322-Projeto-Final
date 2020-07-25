import java.util.Scanner;

public class Game {

	public static void start() {
		// ------ TESTES -------
		int N = 5, M = 5; // MODIFICAR
		Mapa mapa = new Mapa(N, M);
				
		Heroi heroi = Interaction.criarPersonagem();
		mapa.generateMap(heroi);		
		
		for(int i = 0; i < 10; i++) {
			//Scanner read = new Scanner(System.in);
			//int x = read.nextInt();
			mapa.printMap();
			//Interaction.turnoHeroi(heroi, mapa);
			Interaction.turnoMonstros(mapa);
			System.out.println();
			System.out.println("SUA VIDA = " + heroi.getPontosVida());
		}
	}
}
