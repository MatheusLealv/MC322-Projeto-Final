
public class Mapa {
	
	private int N;
	private int M;
	private Celula[][] grid;
	
	public Mapa(int N, int M) {
		this.N = N;
		this.M = M;
		grid = new Celula[N][M * 4+ 3];
	}
	
	void generateMap(Unit hero) {
		// sala 1
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < 4 * M + 3 ; j ++) {
				grid[i][j] = new CelulaVazia(i,j);
			}
		}
		for(int i = 0 ; i < N ; i ++) {
			if(i != 3) {
				grid[i][5] = new Muro(i,5);
				grid[i][11] = new Muro(i,11);
				grid[i][17] = new Muro(i,17);
			}
			else {
				grid[i][5] = new Porta(i,5);
				grid[i][11] = new Porta(i,11);
				grid[i][17] = new Porta(i,17);
			}
		}
		// sala 0
		grid[0][0] = hero;
		grid[4][0] = new Tesouro(4,0);
		grid[1][1] = new Armadilha(1,1);
		grid[0][2] = new Esqueleto(0,2);
		grid[0][3] = new Armadilha(0,3);
		grid[1][3] = new Armadilha(1,3);
		grid[0][4] = new Tesouro(0,4);
		grid[1][4] = new Esqueleto(1,4);
		grid[3][2] = new Armadilha(3,2);
		grid[4][4] = new Tesouro(4,4);
		// sala 1		
		grid[0][6] = new Armadilha(0,6);
		grid[2][6] = new Tesouro(2,6);
		grid[3][8] = new Armadilha(3,8);
		grid[0][9] = new Esqueleto(0,9);
		grid[1][9] = new Armadilha(1,9);
		grid[3][9] = new Tesouro(3,9);
		grid[0][10] = new Goblin(0,10);
		grid[1][10] = new Esqueleto(0,10);
		// sala 2
		grid[3][13] = new Armadilha(3,13);
		grid[0][14] = new Armadilha(0,14);
		grid[4][14] = new Armadilha(4,14);
		grid[0][15] = new Esqueleto(0,15);
		grid[4][15] = new EsqueletoMago(4,15);
		grid[0][16] = new Tesouro(0,16);
		grid[1][16] = new Esqueleto(1,16);
		grid[3][16] = new Armadilha(3,16);
		grid[4][16] = new Goblin(4,16);
		// sala 3
		grid[0][19] = new Armadilha(0,19);
		grid[0][20] = new Armadilha(0,20);
		grid[4][20] = new Tesouro(4,20);
		grid[0][21] = new Tesouro(0,21);
		grid[1][21] = new Esqueleto(1,21);
		grid[4][21] = new EsqueletoMago(4,21);
		grid[0][22] = new Goblin(0,22);
		grid[1][22] = new Esqueleto(1,22);
		grid[2][22] = new Armadilha(2,22);
		grid[3][22] = new Armadilha(3,22);
		grid[4][22] = new EsqueletoMago(4,22);
	}

	protected void trocaCel(int a , int b , int c , int d) {
		Celula A = grid[a][b];
		Celula B = grid[c][d];
		grid[a][b] = B;
		grid[c][d] = A;
		grid[a][b].atualizarPos(a,b);
		grid[c][d].atualizarPos(c,d);
	}
	public int getN() {
		return this.N;
	}
	
	public int getM() {
		return this.M;
	}
	
	public Celula[][] getMapa(){
		return this.grid;
	}
	
	public Celula getCelula(int x, int y) {
		return this.grid[x][y];
	}
}
