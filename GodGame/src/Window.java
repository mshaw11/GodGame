import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Window extends JPanel {
	
	private static final long serialVersionUID = 9034494958129720942L;
	
    public void actionPerformed(ActionEvent e){
    	repaint();
    }

	public Window(int width, int height, String title, Game game){
		System.out.println("Created GUI on EDT? "
				+ SwingUtilities.isEventDispatchThread());
		JFrame f = new JFrame(title);

		
		f.setPreferredSize(new Dimension(width, height));
		f.setMaximumSize(new Dimension(width, height));
		f.setMinimumSize(new Dimension(width, height));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.add(game);
		f.pack();
		game.start();
	}

}
