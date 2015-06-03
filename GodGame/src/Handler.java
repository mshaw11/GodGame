import java.awt.Graphics;
import java.util.LinkedList;


//For updating and rendering all game objects

public class Handler {
	//Linked list of all game objects
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	//Update is for changing data before draw
	public void update(){
		for (int i = 0; i<object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.update();
		}
	}
	// Render is draw - draw for every game object
	public void render(Graphics g){
		for (int i = 0; i<object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	//Adds object to the game object list for draw and updating
	public void addObject(GameObject object){
		this.object.add(object);
	}
	//Removes object from the game object list
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
}
