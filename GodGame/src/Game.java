import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 3716160794145432149L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	private boolean running = false;
	private Thread thread;
	
	private Random r;
	private Handler handler;
	
	public Game() {
		
		handler = new Handler();	
		
		new Window(WIDTH, HEIGHT, "Game", this);
		
		this.addKeyListener(new KeyInput(handler));
		
		r = new Random();
		
		//for (int i = 0; i<50; i++){
		//	handler.addObject(new Player(0,0,ID.Player));
		//}
		
		handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player));
		handler.addObject(new Player(WIDTH/2-100,HEIGHT/2-100,ID.Player2));
		handler.addObject(new Sprite(100,100,ID.Player));
	}

	public void init() {

	}

	// CALLED TICK IN TUTORIAL
	private void update() {
		handler.update();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);
		
		g.dispose();
		bs.show();
	}

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		long timer = System.currentTimeMillis();

		while (running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;

			if (delta >= 1) {
				// CALLED TICK IN TUTORIAL
				update();
				updates++;
				delta--;
			}

			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " Ticks, FPS: " + frames);
				updates = 0;
				frames = 0;
			}

		}

		stop();

	}

	protected synchronized void start() {
		if (running) {
			return;
		} else {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	private synchronized void stop() {
		if (!running) {
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
	
	public static void main(String[] args) {
		new Game();
	}

}