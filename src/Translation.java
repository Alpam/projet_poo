import java.util.ArrayList;

public class Translation {
	public static ArrayList<Point> translation(ArrayList<Point> l, Point v) {
		for (Point p:l) {
			p.add(v);
		}
		return l;
	} 
}
