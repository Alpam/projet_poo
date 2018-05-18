import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JPanel;

public class Afficheur{
	
	int height;
	int width;
	int foot;
	JFrame frame;
	Panneau panel;
	
	public static void main(String[] args) {
		Afficheur aff = new Afficheur(1000,1000,500);
		ArrayList<Point> l = new ArrayList<Point>();
		l.add(new Point(0,0,false));
		l.add(new Point(400,400,true));
		aff.affiche_polygone(l);
		ArrayList<Point> m = new ArrayList<Point>();
		m.add(new Point(0,400,false));
		m.add(new Point(400,0,true));
		aff.affiche_polygone(m);
	}
	
	public Afficheur(int height, int width, int foot) {
			this.height = height;
			this.width = width;
			this.foot = foot;
			this.frame = new JFrame("DEMO");
			this.frame.setSize(height,width);
			this.frame.setLocationRelativeTo(null);
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ArrayList<Point> l= new ArrayList<Point>();
			this.panel = new Panneau(height,width,l,grille());
			this.frame.add(this.panel);

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
	
	public void affiche_polygone(ArrayList<Point> l) {
		this.panel.list = l;
		this.panel.repaint();
		this.panel.setVisible(true);
	}
	
	public void affiche_normalised_polygone(ArrayList<Point> l) {
		ArrayList<Point> n;
		Point b = Transformation.barycentre(l);
		System.out.println("l:"+b.x+"|"+b.x);
		n=Transformation.shrink(l);
		b = Transformation.barycentre(n);
		System.out.println("n:"+b.x+"|"+b.x);
		Point t=l.get(0);
		int x_min = t.x, y_min = t.y;
		for(Point p : n) {
			if(p.x<x_min) {x_min = p.x;}
			if(p.y<y_min) {y_min = p.y;}
		}
		if(x_min<0 || y_min<0) {
			if(x_min<0) {x_min = x_min*-1;}
			if(y_min<0) {y_min = y_min*-1;}
			n = Transformation.translation(n,new Point(x_min,y_min));
		}
		else {
			n = new ArrayList<Point>(n);
		}

		//n=Transformation.translation(n, new Point(250,250));
		affiche_polygone(n);
	}
}


