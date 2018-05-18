import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("invalid number of args");
		}
		parser test = new parser(args[0]);
		ArrayList<Point> t = new ArrayList<Point>();
		t = Transformation.normalise_centralise_array(test.figure);
		t = Transformation.rotation(t, 90);
		Afficheur aff = new Afficheur(1200,1000,200);
		aff.affiche_polygone(t);
	}

}
