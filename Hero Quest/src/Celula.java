
public class Celula {
	protected int x;
	protected int y;
	public Celula(int x , int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	public boolean atrapalhaVisao(Celula C) {
		if((C instanceof Monstro) || (C instanceof Armadilha) || (C instanceof Tesouro) || (C instanceof CelulaVazia)) {
			return true;
		}
		return false;
	}
	
	public boolean isVisible(Mapa mapa, Celula C) {
		if(!atrapalhaVisao(C)) {
			return true;
		}
		if(C.getX() != this.x && C.getY() != this.y) {
			return false;
		}
		
		if(C.getX() == this.x) {
			int minY = Math.min(this.y, C.getY());
			int maxY = Math.max(this.y, C.getY());
			
			for(int j = minY + 1; j < maxY; j++) {
				Celula cel = mapa.getCelula(this.x, j);
				if( (cel instanceof Muro) || (cel instanceof Porta) || (cel instanceof Monstro)) {
					return false;
				}
			}
			return true;
		}
		int minX = Math.min(this.x, C.getX());
		int maxX = Math.max(this.x, C.getX());
		
		for(int j = minX + 1; j < maxX; j++) {
			Celula cel = mapa.getCelula(j, this.y);
			if( (cel instanceof Muro) || (cel instanceof Porta) || (cel instanceof Monstro)) {
				return false;
			}
		}
		return true;
	}
	
	protected void atualizarPos(int x , int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "??";
	}
	
}
