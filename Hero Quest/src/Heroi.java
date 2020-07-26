import java.util.*;

public class Heroi extends Unit {
	private String nome;
	
	private Armadura armadura;
	
	public Heroi(String nome, int numDadosAtaque, int numDadosDefesa, int pontosVida, int pontosInteligencia, ArrayList<Arma> armas,ArrayList<Magia> magias, int posx,int posy) {
		super(numDadosAtaque,numDadosDefesa,pontosVida,pontosInteligencia,armas, magias, posx,posy);
		this.nome = nome;

		this.armadura = new Armadura(0);
	}
	public String getNome() {
		return this.nome;
	}
	public void diminuirVida(int x) {
		this.atualizarPV(this.getPontosVida() - Math.max(0,x-this.armadura.getDefesa()));
	}
	public void atualizarArmadura(Armadura armadura) {
		if(armadura.getDefesa()>this.armadura.getDefesa()) {
			this.armadura = armadura;
		}
 	}
	
	public void tomarArmadilha(Armadilha armadilha) {
		danoDireto(armadilha.getDano());
	}

	public void procurarTesouro(Mapa mapa, Heroi heroi) {
		mapa.printMap(this);
		Celula[][] grid = mapa.getMapa();
		Scanner read = new Scanner(System.in);
		String c;
		while(true) {
			System.out.println("Você pode procurar um tesouro nas salas adjacentes com wasd");
			c = read.nextLine();
			if (c.equals("w") && x >= 0) {
				this.procurarTesouro(mapa, grid[x-1][y], heroi);
				break;
			} else
			if (c.equals("d") && (y+1) < mapa.getM()) {
				this.procurarTesouro(mapa, grid[x][y+1], heroi);
				break;
			} else
			if (c.equals("s") && (x+1) < mapa.getN()) {
				this.procurarTesouro(mapa, grid[x+1][y], heroi);
				break;
			} else 
			if (c.equals("a") && (y-1) >= 0) {
				this.procurarTesouro(mapa, grid[x][y-1], heroi);
				break;
			} else if(!c.equals("0")) {
				System.out.println("Por favor faça uma ação válida");
				
			}
			mapa.printMap(this);
		}
	}
	
	public void procurarTesouro(Mapa mapa, Celula C, Heroi heroi) {
		//PODE ENCONTRAR UM MONSTRO
		//O QUE FAZER QUANDO ENCONTRAR UM MONSTRO ?
		
		
		if(C instanceof Tesouro) {
			Tesouro tesouro = (Tesouro)(C);
			ArrayList<Dropavel> bau = tesouro.getTesouro(this);
			if(!bau.isEmpty() && bau.get(0) instanceof Monstro) {
				C = (Celula) bau.get(0);
				mapa.setCelula(C.getX(), C.getY(), C);
				mapa.printMap(heroi);
			}
			else {
				for(Dropavel item : bau) {
					if(item instanceof Arma) {
						this.addArma((Arma)item);
					}
					if(item instanceof Armadura) {
						this.atualizarArmadura((Armadura)item);
					}
					if(item instanceof Magia) {
						this.addMagia((Magia)item);
					}
				}
				mapa.setCelula(C.getX(), C.getY(), new CelulaVazia(C.getX(), C.getY()));
			}
		}
		else {
			System.out.println("Nada encontrado!");
		}
	}
	
	public void moveUp(Mapa mapa) {
		if(this.x == 0) {
			return;
		}
		Celula to = mapa.getCelula(this.x - 1, this.y);
		if(to instanceof Armadilha) {
			tomarArmadilha((Armadilha)to);
			to = new CelulaVazia(to.getX(), to.getY());
			mapa.setCelula(to.getX(), to.getY(), to);
		}
		else if(to instanceof Porta) {
			((Porta)to).abrir(mapa);
		}
		else if(!(to instanceof CelulaVazia)) {
			System.out.println("Movimento Inválido");
			return;
		}
		mapa.trocaCel(this.x, this.y, this.x - 1, this.y);
	}
	
	public void moveDown(Mapa mapa) {
		if(this.x == mapa.getN() - 1) {
			return;
		}
		Celula to = mapa.getCelula(this.x + 1, this.y);
		if(to instanceof Armadilha) {
			tomarArmadilha((Armadilha)to);
			to = new CelulaVazia(to.getX(), to.getY());
			mapa.setCelula(to.getX(), to.getY(), to);
		}
		else if(to instanceof Porta) {
			((Porta)to).abrir(mapa);
		}
		else if(!(to instanceof CelulaVazia)) {
			System.out.println("Movimento Inválido");
			return;
		}
		mapa.trocaCel(this.x, this.y, this.x + 1, this.y);
	}
	
	public void moveLeft(Mapa mapa) {
		if(this.y == 0) {
			return;
		}
		Celula to = mapa.getCelula(this.x, this.y - 1);
		if(to instanceof Armadilha) {
			tomarArmadilha((Armadilha)to);
			to = new CelulaVazia(to.getX(), to.getY());
			mapa.setCelula(to.getX(), to.getY(), to);
		}
		else if(to instanceof Porta) {
			((Porta)to).abrir(mapa);
		}
		else if(!(to instanceof CelulaVazia)) {
			System.out.println("Movimento Inválido");
			return;
		}
		mapa.trocaCel(this.x, this.y, this.x, this.y - 1);
	}
	
	public void moveRight(Mapa mapa) {
		if(this.y == mapa.getM() - 1) {
			return;
		}
		Celula to = mapa.getCelula(this.x, this.y + 1);
		if(to instanceof Armadilha) {
			tomarArmadilha((Armadilha)to);
			to = new CelulaVazia(to.getX(), to.getY());
			mapa.setCelula(to.getX(), to.getY(), to);
		}
		else if(to instanceof Porta) {
			((Porta)to).abrir(mapa);
		}
		else if(!(to instanceof CelulaVazia)) {
			System.out.println("Movimento Inválido");
			return;
		}
		mapa.trocaCel(this.x, this.y, this.x, this.y + 1);
	}
	
	public boolean isAlive() {
		if(this.getPontosVida() <= 0) {
			return false;
		}
		return true;
	}
	
	public void tomarPocao(Pocao pocao) {
		this.aumentarVida(pocao.getVidaExtra());
	}
	
	@Override
	public void death(Mapa mapa) {
		System.out.println("Você morreu e foi consumido pelas trevas");
	}
	
	
}
