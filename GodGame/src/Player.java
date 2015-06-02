import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Player extends GameObject {
	
	Random r = new Random();
	
	public Player(int x, int y, ID id){
		super(x, y, id);
		
		velX=r.nextInt(5) + 1;
		velY=r.nextInt(5);
		
	}

	@Override
	public void update() {
		xPos+=velX;
		yPos+=velY;
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(xPos, yPos, 32, 32);
		
	}
	
}
