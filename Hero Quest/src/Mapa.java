
public class Mapa {
	
	private int N;
	private int M;
	private Celula[][] grid;
	
	public Mapa(int N, int M) {
		this.N = N;
		this.M = M;
		grid = new Celula[N][M * 4];
	}
	
	void generateMap(Unit hero) {
		// sala 1
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
				grid[i][j] = new CelulaVazia(i,j);
			}
		}
		grid[2][4] = new Porta(2,4);
		grid[0][0] = hero;
		grid[0][2] = new Esqueleto(0,2);
		grid[1][4] = new Esqueleto(1,4);
		// sala 2
		for(int i = 0 ; i < N ; i ++) {
			for(int j = M ; j < 2*M ; j ++) {
				grid[i][j] = new CelulaVazia(i,j);
			}
		}
		grid[2][9] = new Porta(2,9);
		grid[0][8] = new Esqueleto(0,8);
		grid[0][9] = new Goblin(0,9);
		grid[1][9] = new Esqueleto(1,9);	
		// sala 3
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 2*M ; j < 3*M ; j ++) {
				grid[i][j] = new CelulaVazia(i,j);
			}
		}
		grid[2][14] = new Porta(2,14);
		grid[0][13] = new Esqueleto(0,13);
		grid[1][14] = new Esqueleto(1,14);
		grid[4][13] = new EsqueletoMago(4,13);
		grid[4][14] = new Goblin(4,14);
		// sala 4
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 3*M ; j < 4*M ; j ++) {
				grid[i][j] = new CelulaVazia(i,j);
			}
		}
		grid[0][19] = new Goblin(0,19);
		grid[1][18] = new Esqueleto(1,18);
		grid[1][19] = new Esqueleto(1,19);
		grid[4][19] = new EsqueletoMago(4,19);
		grid[4][18] = new EsqueletoMago(4,18);
	}

	public int getN() {
		return this.N;
	}
	
	public int getM() {
		return this.M;
	}
}
