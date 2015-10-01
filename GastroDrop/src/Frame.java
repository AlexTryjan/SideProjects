import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Frame extends JApplet implements MouseListener, KeyListener, Runnable {
    Graphics bufferGraphics;
  Image offscreen;

  	ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    private int appletSize_x;
    private int appletSize_y;
    private double height;
    private Color color = Color.WHITE;
    private double xpos;
    private double ypos;
    private int radius;
    private Gastro player;
    private int velx;
    ArrayList<Gastro> players = new ArrayList<Gastro>();
    boolean newfruit = false;
    public int total = 1000;
    boolean pause = false;
    public int BALLPRICE = 10;
    public int PLAYERLENGTH;
    public int POWERUP = 0;
    int powercount = 0;
    int count = 1;
    public int POWERPRICE = 100;
    public int POWERTIME = 200;
    public int POWERINC = 1;
    public int WORTH = 1;
    public int EXPANDPRICE = 50;
    public int playerW = 9;
    private Image one;
    private Image two;
    MediaTracker tr;
    public boolean SPECIAL = false;
    int INCREASEHOLDER = 1;
    


	
	public void init() {

		one = getImage(getDocumentBase(), getParameter("lolone.jpg"));
		two = getImage(getDocumentBase(), getParameter("loltwo.jpg"));
		player = new Gastro();
		players.add(player);
		appletSize_x = getSize().width;
        appletSize_y = getSize().height;
        
		fruits.add(new Fruit());
		addKeyListener(this);
		this.setFocusable(true);
		addMouseListener(this);
  setBackground(Color.black);
      offscreen = createImage(getSize().width,getSize().height);
       bufferGraphics = offscreen.getGraphics();
        new Thread(this).start();
    }
	
	public void run() {
		
		
		
        for(;;) { // animation loop never ends
        	if(newfruit) {fruits.add(new Fruit()); newfruit = false;}
        	bufferGraphics.clearRect(0, 0, getSize().width,getSize().height);
        	/*for(Fruit f: fruits){
            if (f.isFalling) {
            	
            	if(f.radius >= 10) {f.GRAVITY = -9;}
            	if(f.radius >= 16) {f.GRAVITY = -15;}
            	if(f.radius < 10 && f.radius >= 5) {f.GRAVITY = -4;}
            	if(f.radius < 5) {f.GRAVITY = -1;}
            	
                if(f.height - f.radius > 0) {
                    f.height =  f.height + (.5 * f.GRAVITY * (f.time * f.time) );
                    f.ypos = appletSize_y - f.height;
                    f.time += .02;
                } else {
                    f.isFalling = false;
                    f.time = 0;
                }
            }
            xpos = f.xpos;
            ypos = f.ypos;
            height = f.height;
            radius = f.radius;
            color = f.color(f.color);
            repaint();
           
        	}
        	for(Gastro g: players) {
        		velx = g.velx;
                ypos = g.locy;
                color = Color.YELLOW;
        		g.locx = g.locx + velx;
        		if(g.locx <= -5) g.locx = 504;
        		if(g.locx >= 505) g.locx = -4;
        		xpos = g.locx;
        		
        		repaint();
        	}*/
        	repaint();
        	try {
                Thread.sleep(10); 
            //Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        	
        				for(Fruit f: fruits){
        				if((f.ypos + f.radius) >= (player.locy + 10))
        					if(checkCollisions(f)) {
        						total+=WORTH;
        						f.isFalling = false;
        						f.color = 27;
        					}
        				}
        		int j = fruits.size();
       	       	for(int i = 0; j > 0 && i < j; i++) {
       	       		if(fruits.get(i).isFalling == false) {
       	       			fruits.remove(i);
       	       			fruits.add(new Fruit());
      	                j--;
       	                i--;
        	  		}
              	}
        	
       	       	
        	}
        }
        

    //Overriding the paint method
    public void paint(Graphics g) {
     //bufferGraphics.clearRect(0, 0, getSize().width,getSize().height);
        
    	if(pause) {
    			bufferGraphics.clearRect(0, 0, getSize().width,getSize().height);
    			
    			tr = new MediaTracker(this);
    		      one = getImage(getCodeBase(), "lolone.jpg");
    		      tr.addImage(one,0);
    		      bufferGraphics.drawImage(one, 0, 0, this);
    			
    			
    			setFont(new Font("Courier New", Font.PLAIN, 32));
    	        bufferGraphics.setColor(Color.WHITE);
    	    	bufferGraphics.drawString("You have " + Integer.toString(total) + " points!", 100, 250);
    	    	bufferGraphics.drawString("("+BALLPRICE+"pts) Press 'B' for one extra ball", 100, 280);
    	    	bufferGraphics.drawString("("+POWERPRICE+"pts) Press 'N' to speed up POWER recharge rate", 100, 300);
    	    	bufferGraphics.drawString("("+EXPANDPRICE+"pts) Press 'M' to expand platform", 100, 320);
    	    	bufferGraphics.drawString("Press 'P' to resume play.", 100, 340);
    	    	if(POWERUP == 100) {
    	    		if(count ==1){bufferGraphics.setColor(Color.BLUE);count = 0;}
    	    		else {bufferGraphics.setColor(Color.WHITE);count = 1;}}
    	    	bufferGraphics.drawRect(125, 5, POWERUP, 10);
    	    	bufferGraphics.drawString("POWER BAR:  "+POWERUP+" / 100", 100, 40);
    	    	
    	    	g.drawImage(offscreen,0,0,this);
    	    	return;
    	}
    	
    	if(POWERUP == 0) {POWERINC = INCREASEHOLDER;SPECIAL = false;WORTH = 1;}
    	if(SPECIAL){if(count ==1){bufferGraphics.drawImage(one, 250, 250, this);count = 0;}
    				else {bufferGraphics.drawImage(two, 250, 250, this);count = 1;}}
    	if(powercount >= POWERTIME) {POWERUP+=POWERINC; if(POWERUP > 100) {POWERUP = 100;}powercount = 0;}
    	
    	if(POWERUP == 100) {
    		if(count ==1){bufferGraphics.setColor(Color.BLUE);count = 0;}
    		else {bufferGraphics.setColor(Color.WHITE);count = 1;}}
    	
    	powercount++;
    	bufferGraphics.drawRect(125, 5, POWERUP, 10);
    	for(Fruit f: fruits){
            if (f.isFalling) {
            	
            	if(f.radius >= 10) {f.GRAVITY = -4;}
            	if(f.radius >= 16) {f.GRAVITY = -3;}
            	if(f.radius < 10 && f.radius >= 5) {f.GRAVITY = -2;}
            	if(f.radius < 5) {f.GRAVITY = -1;}
            	
                if(f.height - f.radius > -50) {
                    f.height =  f.height + (.5 * f.GRAVITY * (f.time * f.time) );
                    f.ypos = appletSize_y - f.height;
                    f.time += .02;
                } else {
                    f.isFalling = false;
                    f.time = 0;
                }
            }
            xpos = f.xpos;
            ypos = f.ypos;
            height = f.height;
            radius = f.radius;
            color = f.color(f.color);
    	
    	bufferGraphics.setColor(color);
        int x = (int) xpos;
        int y = (int) ypos;
        if(color.equals(Color.YELLOW)) {
        	bufferGraphics.fillRect(x, y, 10, 10);
        }
        else {bufferGraphics.fillOval (x, y, 2 * radius, 2 * radius);}
        
    }
    	
    	for(Gastro p: players) {
    		velx = p.velx;
            ypos = p.locy;
            color = Color.YELLOW;
    		p.locx = p.locx + velx;
    		if((p.locx+(playerW/2)) <= -5) p.locx = (504-(playerW/2));
    		if((p.locx) >= 505+(playerW/2)) p.locx = -4-(playerW/2);
    		xpos = p.locx;
    		bufferGraphics.setColor(color);
            int x = (int) xpos;
            int y = (int) ypos;
            if(color.equals(Color.YELLOW)) {
            	bufferGraphics.fillRect(x, y, playerW/2, playerW/2);
            }
            else {bufferGraphics.fillOval (x, y, 2 * radius, 2 * radius);}
    	}
    	setFont(new Font("Courier New", Font.PLAIN, 32));
        bufferGraphics.setColor(Color.WHITE);
    	bufferGraphics.drawString(Integer.toString(total), 250, 250);
   g.drawImage(offscreen,0,0,this);
    }

	public void mouseClicked(MouseEvent e) {newfruit = true;}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void keyPressed(KeyEvent e) {
		if(!SPECIAL){
			if(e.getKeyCode() == KeyEvent.VK_P) {pause = !pause; repaint();}
			if(e.getKeyCode() == KeyEvent.VK_B && total >= BALLPRICE) {newfruit = true; total = total - BALLPRICE; BALLPRICE = BALLPRICE*2;}
			if(e.getKeyCode() == KeyEvent.VK_N && total >= POWERPRICE) {total = total - POWERPRICE; POWERPRICE = POWERPRICE*2; POWERINC = POWERINC*2;INCREASEHOLDER = POWERINC;}
			if(e.getKeyCode() == KeyEvent.VK_SPACE && POWERUP == 100) {WORTH = 3;POWERINC = -20;SPECIAL = true;}
			if(e.getKeyCode() == KeyEvent.VK_M && total >= EXPANDPRICE) {total = total - EXPANDPRICE; EXPANDPRICE = EXPANDPRICE*2; playerW = playerW*3;}
		}
	    if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
	    player.velx = -5;
	    else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
	    player.velx = 5;
	    else{}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	
	public boolean checkCollisions(Fruit f) {
		for(int i = (int)((-1)*(playerW/2)) - 2; i < (int)(playerW/2) + 2; i++)
			for(int j = -6; j < 7; j++)
				if((((player.locx + i) - f.xpos)*((player.locx + i) - f.xpos)) + (((player.locy + j) - f.ypos)*((player.locy + j) - f.ypos)) <= (f.radius*f.radius))
					//There is a collision
					return true;
		return false;
	}
}
