
public class Point {
	int x;
	int y;
	boolean drawable;
	
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
}
