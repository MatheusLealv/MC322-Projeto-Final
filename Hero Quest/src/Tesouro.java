//MAMAAAAAE
import java.util.*;
public class Tesouro extends Celula{
	public Tesouro(int x , int y) {
		super(x,y);
		
	}
	public ArrayList<Dropavel> getTesouro(Unit PC){
		ArrayList<Dropavel> inside = new ArrayList<Dropavel>();
		Random rng = new Random();
		Scanner read = new Scanner(System.in);
		int rnd = rng. nextInt(5)+1;
		if(rnd == 1) { // dropa arma
			int a = rng.nextInt(3);
			if(a == 0) {
				System.out.println("Uau! Você encontrou uma Espada curta!");
				while(true) {
					System.out.println("0-Pegar espada 1-Ignorar espada");
					String pega = read.nextLine();	
					if(pega.equals("0")) {
						inside.add(new EspadaCurta());
						break;
					} else if(!(pega.equals("1"))) {
						System.out.println("Ação inválida");
					} else {
						break;
					}
				}
			}
			else if(a == 1) {
				System.out.println("Uau! Você encontrou uma Espada Longa!");
				while(true) {
					System.out.println("0-Pegar espada 1-Ignorar espada");
					String pega = read.nextLine();	
					if(pega.equals("0")) {
						inside.add(new EspadaLonga());
						break;
					} else if(!(pega.equals("1"))) {
						System.out.println("Ação inválida");
					} else {
						break;
					}
				}
			}
			else {
				int sz = rng.nextInt(3)+1;
				System.out.println("Uau! Você achou "+sz+" punhais!");
				for(int j = 0 ; j < sz; j ++)
					inside.add(new Punhal());
			}
		} else if(rnd == 2) { // dropa magia
			int a = rng.nextInt(4);
			if(a == 0) {
				System.out.println("Uau! Você achou uma magia Simple Heal!");
				inside.add(new SimpleHeal(PC));
			}
			else if(a == 1) {
				System.out.println("Uau! Você achou uma magia Magic Missile!");
				inside.add(new MagicMissile(PC));
			}
			else if(a == 2) {
				System.out.println("Uau! Você achou uma magia Fireball!");
				inside.add(new Fireball(PC));
			}
			else {
				System.out.println("Uau! Você achou uma magia Teleport!");
				inside.add(new Teleport(PC));
			}
		} else if(rnd == 3) { //dropa armadura
			int a = rng.nextInt(3);
			System.out.println("Uau! Você achou uma armadura com "+(a+1)+" de defesa");
			if(a == 0) {
				inside.add(new Armadura(a+1));
			}
			else if(a == 1) {
				inside.add(new Armadura(a+2));
			}
			else if(a == 2) {
				inside.add(new Armadura(a+3));
			}
		}
		else if(rnd == 4){
			int a = rng.nextInt(3) + 1;
			if(a == 0) {
				System.out.println("Oh não! Um esqueleto!");
				inside.add((Dropavel) new Esqueleto(getX() , getY()));
			}
			else if(a == 1) {
				System.out.println("Oh não! Um esqueleto mago!");
				inside.add((Dropavel) new EsqueletoMago(getX() , getY()));
			}
			else {
				System.out.println("Oh não! Um goblin!");
				inside.add((Dropavel) new Goblin(getX() , getY())); 
			}
		}
		else if(rnd == 5) {
			System.out.println("Uau! Uma poção! Você bebe ela e se sente mais vivo!");
			((Heroi) PC).tomarPocao(new Pocao());
		}
		read.close();
		return inside;
	}
	
	@Override
	public String toString() {
		return "$$";
	}
	
}
