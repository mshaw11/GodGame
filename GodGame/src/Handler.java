import java.awt.Graphics;
import java.util.LinkedList;


//For updating and rendering all game objects

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void update(){
		for (int i = 0; i<object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.update();
		}
	}
	
	public void render(Graphics g){
		for (int i = 0; i<object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
}
