import java.util.Scanner;

public class Game {

	public static void start() {
		// ------ TESTES -------
		int N = 5, M = 5; // MODIFICAR
		Mapa mapa = new Mapa(N, M);
				
		Heroi heroi = Interaction.criarPersonagem();
		mapa.generateMap(heroi);		
		
		while(heroi.isAlive()) {
			mapa.printMap();
			Interaction.turnoHeroi(heroi, mapa);
			if(heroi.isAlive() == false) {
				break;
			}
			Interaction.turnoMonstros(mapa);
		}
	}
}
