import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Game {
	
	private boolean running = false;
	private Thread thread;
	static GameTimer gameLoop;
	
	public static void main(String [] args){
		Game game = new Game();
		gameLoop = new GameTimer();
	}
	
	public Game() {
		//Set up relevant objects - players etc.
		//Start game timer
		//
		createAndShowGUI();
	}
	
	 private static void createAndShowGUI() {
	        System.out.println("Created GUI on EDT? "+
	        SwingUtilities.isEventDispatchThread());
	        JFrame f = new JFrame("Swing Paint Demo");
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        f.add(new CanvasPanel());
	        f.setSize(250,250);
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
	        f.pack();
	    }
	 



	
}