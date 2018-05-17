import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel{
	public Panneau() {}
	public void traceLigne(Graphics g, Point p1, Point p2) {
		g.drawLine(p1.x,p1.y,p2.x,p2.y);
	}
}
