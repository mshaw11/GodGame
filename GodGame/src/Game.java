import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Game {
	
	public static void main(String [] args){
		Game game = new Game();
	}
	
	public Game() {
		//Set up relevant objects - players etc.
		//Start game timer
		//
		setupGameWindow();
	}
	
	
	public void setupGameWindow(){
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
	}
	
	 private static void createAndShowGUI() {
	        System.out.println("Created GUI on EDT? "+
	        SwingUtilities.isEventDispatchThread());
	        JFrame f = new JFrame("Swing Paint Demo");
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        f.add(new CanvasPanel());
	        f.setSize(250,250);
	        f.setVisible(true);
	    } 


	
}