import javax.swing.JFrame;
import javax.swing.JPanel;

public class Afficheur extends JFrame {
	public static void main(String[] args) {
		Afficheur aff = new Afficheur();
	}
	
	public Afficheur() {
			int height = 400;
			int width = 400;
			this.setSize(height, width);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Panneau pan = Panneau();
			
			this.setVisible(true);
	}
}

