import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Color;

public class Panneau extends JPanel{
	
	ArrayList<Point> list;
	public Panneau(int h, int w, ArrayList<Point> list){
		this.setPreferredSize(new Dimension(h,w));
		this.setBackground(Color.WHITE);
		this.list = list;
	}
	
	public void paintComponent(Graphics g) {
		Point last = null;
		
		for(Point p : this.list){
			if(last == null) {
				last=p;
				continue;
			}
			if(p.drawable) {
				g.setColor(Color.RED);
				g.drawLine(last.x,last.y,p.x,p.y);
			}
			last = p;
		}
	}
}
