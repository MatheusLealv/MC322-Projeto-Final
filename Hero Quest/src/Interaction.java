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

}
