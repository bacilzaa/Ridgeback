package game.io;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean leftPressed, rightPressed;
	
	/*Player p;
	GameScene gs;
	JavaGame js;
	collectEn ce;
	ControllE cone;
	
	public KeyHandler(Player p) {
		this.p = p;
	}*/
	
	public KeyHandler() {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		/*if(code == KeyEvent.VK_SPACE){
			if(gs.end > 1) {
				cone.count = 0;
				gs.end-=1;
				p.setScore(0);
				ce.hpcount-=1;
				cone.end-=1;
				cone.GO-=1;
			}
		}*/
		
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
		if(code == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

		
	}
}
