
public class Point {
	int x;
	int y;
	boolean drawable;
	
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
		this.drawable = p.drawable;
	}
	
	public Point(boolean isDraw) {
		this.x=0;
		this.y=0;
		this.drawable=isDraw;
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
		this.drawable=true;
	}
	public Point(int x, int y, boolean isDraw) {
		this.x=x;
		this.y=y;
		this.drawable=isDraw;
	}
	public Point add(Point p) {
		return new Point(this.x+p.x, this.y+p.y, this.drawable);
	}
	
	public Point neg() {
		return new Point(this.x*-1,this.y*-1);
	}
	
	public boolean eq(Point p) {
		if(this.x==p.x && this.y==p.y) {return true;}
		else {return false;}
	}
	
	public Point is_in_pav() {
		int i=1,j=1;
		while((i*200)<=this.x) {
			i++;
		}
		while((j*200)<=this.y) {
			j++;
		}
		Point p = new Point(i,j);
		return p;
	}
	
}
