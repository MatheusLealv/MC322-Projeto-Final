import java.util.Scanner;

public class Game {

	public static void start() {
		// ------ TESTES -------
		int N = 5, M = 5; // MODIFICAR
		Mapa mapa = new Mapa(N, M);
				
		Heroi heroi = Interaction.criarPersonagem();
		mapa.generateMap(heroi);		
		
		while(heroi.isAlive()) {
			mapa.printMap(heroi);
			System.out.println("HP: "+heroi.getPontosVida());
			Interaction.turnoHeroi(heroi, mapa);
			if(mapa.getQntMonstros()==0) {
				System.out.println("Bravo! Você foi capaz de derrotar todos os monstros! Você é um herói lendário!");
				System.out.println("FIM");
				break;
			}
			System.out.println("HP: "+heroi.getPontosVida());
			if(heroi.isAlive() == false) {
				System.out.println("morreu");
				break;
			}
			Interaction.turnoMonstros(mapa);
		}
	}
}
