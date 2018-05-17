import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Afficheur extends JFrame {
	public static void main(String[] args) {
		Afficheur aff = new Afficheur();
	}
	
	public Afficheur() {
			int height = 400;
			int width = 400;
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel pan = new Panneau(height,width);
			this.setContentPane(pan);
			this.pack();
			Point p1 = new Point(10,10);
			Point p2 = new Point(310,310);
			Graphics g = pan.getGraphics();
			pan.paintComponent(g);
			this.setVisible(true);
	}
	


