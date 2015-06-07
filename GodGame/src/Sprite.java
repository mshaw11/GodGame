import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Sprite extends GameObject {
	
	static String imageURL = "images/ironMan.png";
	 BufferedImage img;
	
	public Sprite(int x, int y, ID id) {
		
		super (x,y,id);
		img = null;
		try {
		    img = ImageIO.read(new File(imageURL));
		} catch (IOException e) {
			System.out.println("NO FILE OF THIS NAME");
		}
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		xPos+=velX;
		yPos+=velY;
		
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(img, null, super.xPos, super.yPos);
		// TODO Auto-generated method stub
	}
}