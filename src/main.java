import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("invalid number of args");
		}
		parser test= new parser(args[0]);
		ArrayList<Point> t = new ArrayList<Point>();
		t.add(new Point(-200,-200,false));
		t.add(new Point(-200,300,true));
		t.add(new Point(300,300,true));
		t.add(new Point(300,-200,true));
		t.add(new Point(-200,-200,true));
		Afficheur aff = new Afficheur(1000,1000,200);
		aff.affiche_normalised_polygone(t);
	}

}
