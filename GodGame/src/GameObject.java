import java.awt.Graphics;
import java.awt.Graphics2D;


public abstract class GameObject {
	
    protected int xPos = 50;
    protected int yPos = 50;
    protected int width = 20;
    protected int height = 20;
    protected ID id;
    protected int velX, velY;
    
    public GameObject(int x, int y, ID id){
    	xPos = x;
    	yPos = y;
    	this.id = id;
    }
    
    //CALLED TICK IN TUTORIAL
    public abstract void update();
    public abstract void render(Graphics2D g);
    
    public void setX(int xPos){ 
        this.xPos = xPos;
    }

    public int getX(){
        return xPos;
    }

    public void setY(int yPos){
        this.yPos = yPos;
    }

    public int getY(){
        return yPos;
    }
    
    public void setID(ID id){
    	this.id=id;
    }
    
    public ID getID(){
    	return id;
    }
    
    public void setVelX(int velX){ 
        this.velX = velX;
    }

    public int getVelX(){
        return velX;
    }

    public void setVelY(int velY){
        this.velY = velY;
    }

    public int getVelY(){
        return velY;
    }

    public int getWidth(){
        return width;
    } 

    public int getHeight(){
        return height;
    }
}
