import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fruit extends JApplet{
    Graphics bufferGraphics;
  Image offscreen;

    public double xpos;
    public double ypos;
    public int radius;
    public int appletSize_x;
    public int appletSize_y;
    public double time;
    public double height;
    public int color;
    public int GRAVITY = -2;
    public boolean isFalling = true;

    public Fruit() {
    	color = (int) (Math.random()*10);
    	radius = (int) (20*Math.random() + 20);
    	ypos = -535; //DAFUQ? DON"T CHANGE IT WORKS...?Q?!?!?!
        xpos = Math.random()*(500);
        height = appletSize_y - ypos;
    	
    }
    
    /*public void init() {

        xpos = getSize().width/2-10;
        ypos = -40;//0;
        height = appletSize_y - ypos;
        time = 0;
        radius = 7;
        appletSize_x = 300;//3*getSize().width;
        appletSize_y = 3*getSize().height;
  setBackground(Color.black);
      offscreen = createImage(getSize().width,getSize().height);
       bufferGraphics = offscreen.getGraphics();
        new Thread(this).start();
    }*/
    
    public Color color(int color) {
    	switch(color) {
    	case 3:
    	case 4:
    	case 5: return Color.RED;
    	case 6:
    	case 7:
    	case 8: return Color.orange;
    	default: return Color.green;
    	case 27: return Color.PINK;
    	}
    	
    }

    /*public void run() {

        for(;;) { // animation loop never ends
            if (isFalling) {
                if(height - radius > -20) {
                    height =  height + (.5 * GRAVITY * (time * time) );
                    ypos = appletSize_y - height;
                    time += .02;
                } else {
                    isFalling = false;
                    time = 0;
                }
            }
            repaint();
            try {
                Thread.sleep(1000 / 30);
                //Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }*/

    //Overriding the paint method
    /*public void paint(Graphics g) {
     bufferGraphics.clearRect(0, 0, getSize().width,getSize().height);
        bufferGraphics.setColor (color(color));
        int x = (int) xpos;
        int y = (int) ypos;
        bufferGraphics.fillOval (x, y, 2 * radius, 2 * radius);
   g.drawImage(offscreen,0,0,this);
    }*/
    /*
    //Listeners
    public void mousePressed (MouseEvent e) {}
    public void mouseDragged (MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {
        ypos = -40;
        xpos = Math.random()*(getSize().width*.8);
        radius = (int) (20*Math.random());
        height = appletSize_y - ypos;
        color = (int) (Math.random()*10);
        if (height > 0) { isFalling = true; }
    }
    public void mouseExited(MouseEvent e)  {}
    public void mouseMoved   (MouseEvent e) {}
    public void mouseEntered (MouseEvent e) {}
    public void mouseClicked (MouseEvent e) {} */
}