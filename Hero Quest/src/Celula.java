
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
	
	public boolean isVisible(Celula C) {
		int xi = C.getX();
		int yi = C.getY();
		
		if(this.x == xi || this.y == yi) {
			return true;
		}
		return false;
	}
	
	protected void atualizarPos(int x , int y) {
		this.x = x;
		this.y = y;
	}
	
}
