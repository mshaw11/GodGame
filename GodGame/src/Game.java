import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Game implements Runnable {
	
	private boolean running = false;
	private Thread thread;
	
	public static void main(String [] args){
		Game game = new Game();
		game.start();
	}
	
	public Game() {
		run();
		//Set up relevant objects - players etc.
		//Start game timer
		//
		//setupGameWindow();
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
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
	        f.pack();
	    }
	 
	 public void init(){
		 
	 }
	 
	 public void tick(){
		 
	 }
	 
	 public void render(){
		 
	 }

	@Override
	public void run() {
		createAndShowGUI();
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000/numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;
			
			if (delta >= 1){
				ticks++;
				delta--;
			}
			
			render();
			frames++;
			
			if (System.currentTimeMillis()-timer>1000){
				timer+=1000;
				System.out.println(ticks+" Ticks, FPS: "+ frames);
				ticks=0;
				frames=0;
			}
			
		}
		
	} 
	
	private synchronized void start(){
		if (running){
			return;
		} else {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	private synchronized void stop(){
		if (!running){
			return;
		} else {
			running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.exit(1);
		}
	}


	
}