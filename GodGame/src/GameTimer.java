import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class GameTimer implements Runnable {

	private boolean running = false;
	private Thread thread;
	
	public static void main(String [] args){
		Game game = new Game();
	}
	
	public GameTimer() {
		start();

	}
	 
	 public void init(){
		 
	 }
	 
	 public void update(){
		 
	 }
	 
	 public void render(){
		 
	 }

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000/numTicks;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;
			
			if (delta >= 1){
				update();
				updates++;
				delta--;
			}
			
			render();
			frames++;
			
			if (System.currentTimeMillis()-timer>1000){
				timer+=1000;
				System.out.println(updates+" Ticks, FPS: "+ frames);
				updates=0;
				frames=0;
			}
			
		}
		
		stop();
		
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
