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
		mapa.moveHeroi(heroi, roll);

			Scanner read = new Scanner(System.in);
			while(true) {
				System.out.println("Escolha Sua Ação:");
				System.out.println("1-Arma 2-Magia 3-Procurar Tesouro");
				int c = read.nextInt();
				Celula[][] grid = mapa.getMapa();
				if (c==1) {
					realizarAtaque(mapa,heroi);
					break;
				} else
				if (c==2) {
					if(heroi.getMagias().isEmpty()) {
						System.out.println("Você não possui magias");
					} else if(!(heroi instanceof Magico)) {
						System.out.println("Você não pode usar magias. Não tente isso novamente");
					} else {
						realizarMagia(mapa,heroi);
						break;
					}
				} else
				if (c==3) {
					heroi.procurarTesouro(mapa);
					break;
				} else {
					System.out.println("Por favor digite uma ação válida");
				}
			}
		
		//heroi.move(mapa, roll);
	}
	
	public static void utilizarPunhal(Mapa mapa, Heroi heroi, int qtdPunhal) {
		Scanner read = new Scanner(System.in);
		int[] dx = {1, -1, 0, 0, 2, -2, 0, 0, 3, -3, 0, 0};
		int[] dy = {0, 0, 1, -1, 0, 0, 2, -2, 0, 0, 3, -3};	
		
		ArrayList<Arma> minhasArmas = new ArrayList<Arma>();
		
		for(Arma arma: heroi.getArmas()) {
			if((arma instanceof Punhal) && (qtdPunhal > 0)) {
				qtdPunhal --;
				minhasArmas.add(arma);
			}
		}
		
		for(int punhal = 0; punhal < qtdPunhal; punhal ++) {
			System.out.println("Digite o número correspondente ao monstro que deseja apunhalar");
			ArrayList<Monstro> monstros = new ArrayList<>();			
			for(int i = 0; i < 12; i++) {
				int x = heroi.getX() + dx[i], y = heroi.getY() + dy[i];
				if(0 <= x && x < mapa.getN() && 0 <= y && y < mapa.getM()) {
					Celula C = mapa.getCelula(x, y);
					if(C instanceof Monstro) {
						monstros.add((Monstro) C);
					}
				}
			}
			int i = 0;
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
			heroi.combate(mapa,monstro, minhasArmas);
			
		}
		
	}
	public static void realizarAtaque(Mapa mapa, Heroi heroi) {
		Scanner read = new Scanner(System.in);
		int[] dx = {1, -1, 0, 0, 2, -2, 0, 0};
		int[] dy = {0, 0, 1, -1, 0, 0, 2, -2};
		
		int qtdPunhal = 0;
		ArrayList<Arma> minhasArmas = new ArrayList<Arma>();
		for(Arma arma: heroi.getArmas()) {
			if(arma instanceof Punhal) {
				qtdPunhal ++;				
			}
			else {
				minhasArmas.add(arma);
			}
		}
		
		System.out.println("Você possui " + qtdPunhal + "punhais. Digite quantos você quer utilizar");
		int punhaisUsaveis = read.nextInt();
		while(punhaisUsaveis < 0 || punhaisUsaveis > qtdPunhal) {
			punhaisUsaveis = read.nextInt();
		}
		
		utilizarPunhal(mapa, heroi, punhaisUsaveis);
			
		ArrayList<Monstro> monstros = new ArrayList<Monstro>();
		for(int i = 0; i < 4; i++) {
			int x = heroi.getX() + dx[i], y = heroi.getY() + dy[i];
			int distancia = Math.abs(x - heroi.getX()) + Math.abs(y - heroi.getY());
			if(0 <= x && x < mapa.getN() && 0 <= y && y < mapa.getM()) {
				Celula C = mapa.getCelula(x, y);
				if(C instanceof Monstro) {
					monstros.add((Monstro)C);
				}
			}
		}
		int i = 0;
		if(monstros.size() >= 1) {
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
			heroi.combate(mapa,monstro, minhasArmas);
		}
		else {
			System.out.println("Não há monstros para serem atacados");
		}
	}
	
	public static void realizarMagia(Mapa mapa, Heroi heroi) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		ArrayList<Monstro> monstros = new ArrayList<Monstro>();
		ArrayList<Magia> magias = heroi.getMagias();
		for(int i = 0; i < 4; i++) {
			int x = heroi.getX() + dx[i], y = heroi.getY() + dy[i];
			while(0 <= x && x < mapa.getN() && 0 <= y && y < mapa.getM()) {
				Celula C = mapa.getCelula(x, y);
				if(C instanceof Bloqueado) {
					break ;
				}
				if(C instanceof Monstro) {
					monstros.add((Monstro) C);
					break ;
				}
				x += dx[i] ;
				y += dy[i];
			}
		}		
		int i = 0;
		if(magias.size() >= 1) {
			Scanner read = new Scanner(System.in);
			System.out.println("Digite a magia que deseja usar");			
			for(Magia magia: magias) {
				System.out.println(i + " - " + magia );
				i ++ ;
			}
			int operacao = read.nextInt();
			while(operacao < 0 || operacao >= magias.size()) {
				System.out.println("Opção inválida! Digite novamente");
				operacao = read.nextInt();
			}
			Magia magia = magias.get(operacao);
			i = 0 ;
			if(magia instanceof MagiaAtaque) {
				if(monstros.size() >= 1) {
					System.out.println("Digite o número correspondente ao monstro que deseja atacar");
					for(Monstro monstro: monstros) {
						System.out.println(i + " - " + monstro + " at position " + monstro.getX() + ", " + monstro.getY());
						i ++;
					}
					operacao = read.nextInt();
					while(operacao < 0 || operacao >= monstros.size()) {
						System.out.println("Opção inválida! Digite novamente");
						operacao = read.nextInt();				
					}	
					Monstro monstro = monstros.get(operacao);
					heroi.removeMagia(magia);
					((MagiaAtaque) magia).setAlvo(monstro);
					if(magia instanceof MagiaEmArea) {
						((MagiaEmArea) magia).usarMagia(mapa);
					}
					else{
						((MagiaSingle) magia).usarMagia();
					}
					if(monstro.getPontosVida()<=0) monstro.death(mapa);
				}
				else {
					System.out.println("Não há monstros para serem atacados");					
				}
			}
			else if(magia instanceof MagiaHeal) {
				heroi.removeMagia(magia);
				((SimpleHeal) magia).usarMagia();
			}
			else {
				heroi.removeMagia(magia);
				
			}
		}
		else {
			System.out.println("Não há magias disponíveis");
		}	
	}
	
	public static void turnoMonstros(Mapa mapa) {
		mapa.monstroTurno();
	}
}
