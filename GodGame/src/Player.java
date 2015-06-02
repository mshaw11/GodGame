import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Player extends GameObject {
	
	public Player(int x, int y, ID id){
		super(x, y, id);
		
	}

	@Override
	public void update() {
		xPos+=velX;
		yPos+=velY;
		
		
	}

	@Override
	public void render(Graphics g) {
		if(id==ID.Player) g.setColor(Color.red);	
		else if (id==ID.Player2) g.setColor(Color.blue);
		g.fillRect(xPos, yPos, 32, 32);
		
	}
	
}
