package gametest;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class Player {
	
	private int x;
	private int y;
	private int speedx;
	private int speedy;
	private ArrayList<Enermy>e = ControllE.getBorder();
	private static int hp = 3;
	public static int score;
	
	collectEn enhp;
	
	public Player(int x,int y) {
		this.x = x;
		this.y = y;
	}
	//�������͹���ͧ player
	public void supdate(int x,int y) {
		this.speedx =  x;
		this.speedy =  y;
	}
	public void update() {
		x+=speedx;
		y+=speedy;
		
		if(x<0) {
			x = 0;
		}
		if(x>603) {
			x = 603;
		}
	}
	//����Ф�
	public void draw(Graphics2D g2){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Image image = toolkit.getImage(Runner.class.getResource("/image/dog.gif"));
		g2.setColor(Color.red);
		g2.drawImage(image, x, y, 100, 100, null);
		//g2.fillRect(x, y, 32, 32);
		//g2.draw(getBorder());
	}
	
	public Rectangle getBorder() {
		return new Rectangle(x,y,50,50);
	}
	
	public void dumb() {
		for (int i = 0;i< e.size();i++) {
			if(getBorder().intersects(e.get(i).getBorder())) {
				score++;
				e.remove(i);
				System.out.println("score:"+score);
				File s = new File("D:\\CP212 B01\\test\\src\\sound\\Bark.wav");
				PlaySound(s);
			}
			
			else if(e.get(i).y == 360) {
				e.remove(i);
				hp--;
				System.out.println("hp :"+hp);
				enhp.arrhp.remove(i);
				File s = new File("C:\\Users\\Sinner\\Desktop\\java pro\\sinkinwater.wav");
				PlaySound(s);
			}
			 
		}
	}
	
	public int hp() {
		return hp;
	}
	
	public void sethp(int s) {
		hp+=s;
	}
	
	
	public void setscore(int s) {
		score = s;
	}
	
	static void PlaySound(File Sound) {
		try {
			Clip c = AudioSystem.getClip();
			c.open(AudioSystem.getAudioInputStream(Sound));
			c.start();
			//Thread.sleep(c.getMicrosecondLength()/1000);
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}

	
}
