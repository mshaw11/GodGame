import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {

	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	//Called when key is pressed	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		//System.out.println(key);
		
		//For loop to go through game objects in handler
		for (int i = 0;i<handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			
			//If ID of tempObject is equal to Player
			if (tempObject.getID()==ID.Player){
				//KEY EVENTS FOR PLAYER
				
				//If key is == W decrease velY by 5 and so on
				if (key==KeyEvent.VK_W) tempObject.setVelY(-5);
				if (key==KeyEvent.VK_A) tempObject.setVelX(-5);
				if (key==KeyEvent.VK_S) tempObject.setVelY(5);
				if (key==KeyEvent.VK_D) tempObject.setVelX(5);
				
			}
			
			else if (tempObject.getID()==ID.Player2){
				//KEY EVENTS FOR PLAYER
				
				if (key==KeyEvent.VK_UP) tempObject.setVelY(-5);
				if (key==KeyEvent.VK_LEFT) tempObject.setVelX(-5);
				if (key==KeyEvent.VK_DOWN) tempObject.setVelY(5);
				if (key==KeyEvent.VK_RIGHT) tempObject.setVelX(5);
				
			}
		}
		
	}
	
	//Called when key is released
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		System.out.println(key);
		
		//For loop to go through game objects in handler
		for (int i = 0;i<handler.object.size();i++){
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getID()==ID.Player){
				//KEY EVENTS FOR PLAYER
				
				//If key is == W set velY to 0 and so on
				if (key==KeyEvent.VK_W) tempObject.setVelY(0);
				if (key==KeyEvent.VK_A) tempObject.setVelX(0);
				if (key==KeyEvent.VK_S) tempObject.setVelY(0);
				if (key==KeyEvent.VK_D) tempObject.setVelX(0);
				
			}
			
			else if (tempObject.getID()==ID.Player2){
				//KEY EVENTS FOR PLAYER
				
				if (key==KeyEvent.VK_UP) tempObject.setVelY(0);
				if (key==KeyEvent.VK_LEFT) tempObject.setVelX(0);
				if (key==KeyEvent.VK_DOWN) tempObject.setVelY(0);
				if (key==KeyEvent.VK_RIGHT) tempObject.setVelX(0);
				
			}
		}
		
	}
	
	
}
