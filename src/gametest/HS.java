package gametest;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;


public class HS {
	
	int x;
	int y;
	public HS(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics2D g2) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image bi = toolkit.getImage(Runner.class.getResource("/image/heart2.png"));
		g2.setColor(Color.red);
		g2.drawImage(bi, x, y, 90, 95, null);
		//g2.fillRect(x, y, 10, 10);
	}
	
}
