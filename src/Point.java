
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
		this.x=null;
		this.y=null;
		this.drawable=isDraw;
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
		this.drawable=null;
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
}
