import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Gastro implements KeyListener {

	public int locy;
	public int locx;
	public int velx;
	
	public Gastro() {
		velx = -5;
		locy = 480;
		locx = 250;
	}
	
	
	public void keyPressed(KeyEvent e) {
	    if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT);
	    velx = -5;
	    if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT);
	    velx = 5;
	}

	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}
	
}
