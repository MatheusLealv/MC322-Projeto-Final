import java.util.*;

public class Interaction {

	public static Heroi criarPersonagem() {
		Scanner read = new Scanner(System.in);
		System.out.println("Bem vindo a Hero Quest");
		System.out.println("Digite o seu nome de aventureiro");
		String name = read.nextLine();
		
		System.out.println("Digite o número correspondente a classe desejada");
		System.out.println("0-Bárbaro 1-Anão 2-Elfo 3-Feiticeiro");

		int cls = read.nextInt();
		while(true) {
			switch(cls) {
				case 0:
					return new Barbaro(name,0,0);
				case 1:
					return new Anao(name,0,0);
				case 2:
					return new Elfo(name,0,0);
				case 3:
					return new Feiticeiro(name,0,0);
				default:
					System.out.println("Por favor digite um número válido");
					cls = read.nextInt();
			}
		}
	}
	
	public static void turnoHeroi(Heroi heroi,Mapa mapa) {
		DadosRed dado = new DadosRed();
		int roll = dado.roll();
		roll += dado.roll();
		
		//heroi.move(mapa, roll);
	}
	
	public void realizarAtaque(Mapa mapa, Heroi heroi) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		ArrayList<Monstro> monstros = new ArrayList<Monstro>();
		for(int i = 0; i < 4; i++) {
			int x = heroi.getX() + dx[i], y = heroi.getY() + dy[i];
			if(0 <= x && x < mapa.getN() && 0 <= y && y < mapa.getM()) {
				Celula C = mapa.getCelula(x, y);
				if(C instanceof Monstro) {
					monstros.add((Monstro)C);
				}
			}
		}
		int i = 0;
		if(monstros.size() >= 1) {
			Scanner read = new Scanner(System.in);
			System.out.println("Digite o número correspondente ao monstro que deseja atacar");
			for(Monstro monstro: monstros) {
				System.out.println(i + " - " + monstro + " at position " + monstro.getX() + ", " + monstro.getY());
				i ++;
			}
			int operacao = read.nextInt();
			while(operacao < 0 || operacao >= monstros.size()) {
				System.out.println("Opção inválida! Digite novamente");
				operacao = read.nextInt();				
			}
			
			Monstro monstro = monstros.get(operacao);
			heroi.combate(monstro);
		}
		else {
			System.out.println("Não há monstros para serem atacados");
		}
	}
}
