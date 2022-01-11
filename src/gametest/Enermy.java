package gametest;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;



public class Enermy {
	
	int x,y;
	Player p;
	private BufferedImage bi;
	
	public Enermy(int x,int y) {
		this.x=x;
		this.y=y;
		
	}
	public void draw(Graphics2D g2) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Image image = toolkit.getImage(Runner.class.getResource("/image/sinkinwater.png"));
	    Image bi = toolkit.getImage(Runner.class.getResource("/image/ruby.png"));
		g2.setColor(Color.BLUE);
		g2.drawImage(bi, x, y, 40, 40, null);
		if(y > 345){
		    g2.drawImage(image, x-20, 325, 100, 100, null);
		}
		//g2.fillRect(x, y, 32, 32);
		//g2.draw(getBorder());
	}
	public void update(int s) {
		y+=s;
		
	}
	
	public Rectangle getBorder() {
		return new Rectangle(x,y,32,32);
	}
	
	
}
