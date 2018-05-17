import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.ArrayList;

public class Panneau extends JPanel{
	
	ArrayList<Point> list;
	public Panneau(int h, int w, ArrayList<Point> list){
		setPreferredSize(new Dimension(h,w));
		this.list = list;
	}
	
	public void paintComponent(Graphics g) {
		g.drawLine(p1.x,p1.y,p2.x,p2.y);
	}
}
