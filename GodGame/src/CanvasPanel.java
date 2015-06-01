import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;


public class CanvasPanel extends JPanel implements ActionListener {

    RedSquare redSquare = new RedSquare();
    
    Timer t = new Timer(5, this);
    
    public void actionPerformed(ActionEvent e){
    	repaint();
    }

    public CanvasPanel() {

    	t.start();
    	setFocusable(true);
    	setFocusTraversalKeysEnabled(false);
    	
        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                moveSquare(e.getX(),e.getY());
            }
        });
        
        addKeyListener(new KeyAdapter(){
        	public void keyPressed(KeyEvent e){
        		int code = e.getKeyCode();
        		if(code==KeyEvent.VK_UP){
        			up();
        		}
        		if(code==KeyEvent.VK_DOWN){
        			down();
        		}
        		if(code==KeyEvent.VK_LEFT){
        			left();
        		}
        		if(code==KeyEvent.VK_RIGHT){
        			right();
        		}
        		
        	}	
        });

        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
                moveSquare(e.getX(),e.getY());
            }
        });

    }
    
    private void up(){
    	redSquare.setY(redSquare.getY()-2);
    }
    
    private void down(){
    	redSquare.setY(redSquare.getY()+2);
    }

	private void left(){
		redSquare.setX(redSquare.getX()-2);
	}

	private void right(){
		redSquare.setX(redSquare.getX()+2);
	}	   

    private void moveSquare(int x, int y){

        // Current square state, stored as final variables 
        // to avoid repeat invocations of the same methods.
        final int CURR_X = redSquare.getX();
        final int CURR_Y = redSquare.getY();
        final int CURR_W = redSquare.getWidth();
        final int CURR_H = redSquare.getHeight();
        final int OFFSET = 1;

        if ((CURR_X!=x) || (CURR_Y!=y)) {

            // The square is moving, repaint background 
            // over the old square location. 
            repaint(CURR_X,CURR_Y,CURR_W+OFFSET,CURR_H+OFFSET);

            // Update coordinates.
            redSquare.setX(x);
            redSquare.setY(y);

            // Repaint the square at the new location.
            repaint(redSquare.getX(), redSquare.getY(), 
                    redSquare.getWidth()+OFFSET, 
                    redSquare.getHeight()+OFFSET);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        g.drawString("This is my custom Panel!",10,20);

        redSquare.paintSquare(g);
    }


}