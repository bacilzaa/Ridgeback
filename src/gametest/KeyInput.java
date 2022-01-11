package gametest;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//event Keybroad
public class KeyInput implements KeyListener{
	Player p;
	GameScene gs;
	JavaGame js;
	collectEn ce;
	ControllE cone;
	
	public KeyInput(Player p ) {
		this.p = p;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		//System.out.println(key);
		if(key == 32){
			if(gs.end > 1) {
				System.out.println("space");
			cone.count = 0;
			gs.end-=1;
			p.setscore(0);
			ce.hpcount-=1;
			cone.end-=1;
			cone.GO-=1;
			}
		}
		if(key == 39) {
			p.supdate(7, 0);
		}
		if(key == 37) {
			p.supdate(-7, 0);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == 39) {
			p.supdate(0, 0);
		}
		if(key == 37) {
			p.supdate(0, 0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
