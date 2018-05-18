import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Color;


public class Panneau extends JPanel{
	
	ArrayList<Point> list;
	Color color = Color.GREEN;
	ArrayList<Point> grille;
	Color c_g = Color.RED;
	
	public Panneau(int h, int w, ArrayList<Point> l,ArrayList<Point> g){
		this.setPreferredSize(new Dimension(h+20,w+20));
		this.list = l;
		this.grille = g;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Point last = null;

		g2.setStroke(new BasicStroke(1.25f));
		for(Point p : this.grille){
			if(last == null) {
				last=p;
				continue;
			}
			if(p.drawable) {
				g.setColor(this.c_g);
				g.drawLine(last.x,last.y,p.x,p.y);
			}
			last = p;
		}
		g2.setStroke(new BasicStroke(2.5f));
		for(Point p : this.list){
			if(last == null) {
				last=p;
				continue;
			}
			if(p.drawable) {
				g.setColor(this.color);
				g.drawLine(last.x,last.y,p.x,p.y);
			}
			last = p;
		}
	}
}
