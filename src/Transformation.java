import java.util.ArrayList;

public class Transformation {
	public static ArrayList<Point> translation(ArrayList<Point> l, Point v) {
		ArrayList<Point> n = new ArrayList<Point>();
		for (Point p:l) {
			n.add(new Point(p.add(v)));
		}
		return n;
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
	
	public static ArrayList<Point> rotation_around_origin(ArrayList<Point> l, int dg){
		ArrayList<Point> n = new ArrayList<Point>();
		double a = dg*Math.PI/180;
		double ca = Math.cos(a);
		double sa = Math.sin(a);
		for(Point p:l) {
			n.add(new Point((int)(p.x*ca-p.y*sa),(int)(p.x*sa+p.y*ca),p.drawable));
		}
		return n;
	}
	
	public static ArrayList<Point> rotation(ArrayList<Point> l,int dg){
		Point p = barycentre(l);
		ArrayList<Point> tmp = translation(l,p.neg());
		tmp = rotation_around_origin(tmp,dg);
		return tmp = translation(tmp,p);
	}
}
