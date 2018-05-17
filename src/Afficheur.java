import javax.swing.JFrame;
import java.util.ArrayList;

public class Afficheur{
	
	int height;
	int width;
	int foot;
	JFrame frame;
	
	public static void main(String[] args) {
		Afficheur aff = new Afficheur(400,400,20);
	}
	
	public Afficheur(int height, int width, int foot) {
			this.height = height;
			this.width = width;
			this.foot = foot;
			this.frame = new JFrame("DEMO");
			this.frame.setSize(height,width);
			this.frame.setLocationRelativeTo(null);
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ArrayList<Point> l =grille();
			Panneau pan = new Panneau(height,width,l);
			
			this.frame.add(pan);
			this.frame.setVisible(true);
	}
	
	public ArrayList<Point> grille(){
		ArrayList<Point> l = new ArrayList<Point>();
		int i=0;
		boolean b = true;
		while(i<=width) {
			if(b) {l.add(new Point(i,0,false));b=false;}
			else {l.add(new Point(i,height,true));b=true;i+=foot;}
		}
		i=0;
		b=false;
		while(i<=height) {
			if(b) {l.add(new Point(0,i,false));b=false;}
			else {l.add(new Point(width,i,true));b=true;i+=foot;}
		}
		return l;
	}
}


