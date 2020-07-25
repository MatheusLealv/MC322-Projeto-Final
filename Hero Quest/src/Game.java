import java.util.Scanner;

public class Game {

	public static void start() {
		// ------ TESTES -------
		int N = 5, M = 5; // MODIFICAR
		Mapa mapa = new Mapa(N, M);
				
		Heroi heroi = Interaction.criarPersonagem();
		mapa.generateMap(heroi);		
		
		while(true) {
			mapa.printMap();
			Interaction.turnoHeroi(heroi, mapa);
			Interaction.turnoMonstros(mapa);
		}
	}
}
