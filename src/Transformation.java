import java.util.ArrayList;

public class Transformation {
	public static ArrayList<Point> translation(ArrayList<Point> l, Point v) {
		for (Point p:l) {
			p.add(v);
		}
		return l;
	}
	
	public static Point barycentre(ArrayList<Point> l) {
		int x_t=0,y_t=0,i=0;
		for (Point p : l) {
			x_t += p.x;
			y_t += p.y;
			i += 1;
		}
		Point p = new Point((int)(x_t/i),(int)(y_t/i));
		return p;
	}
}
