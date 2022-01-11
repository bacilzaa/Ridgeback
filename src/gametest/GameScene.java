package gametest;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.font.*;

public  class GameScene extends JPanel implements ActionListener{
	Timer loop;
	Player p;
	ControllE enermy;
	collectEn hp;
	JavaGame js;
	public static int end = 1;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image image = toolkit.getImage(Runner.class.getResource("/image/bg.gif"));
    Read read;
    int run;
	
	public GameScene() {
		setBackground(Color.WHITE);
		loopstart();
		p = new Player(100,350);
		enermy = new ControllE(1500);
		addKeyListener(new KeyInput(p));
		setFocusable(true);
		hp = new collectEn();
		setLayout(null);
	}
 
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		if(!(end%2==0)){
		g2.setColor(Color.DARK_GRAY);
		g2.drawImage(image, 0, 0, JavaGame.WIDTH,JavaGame.HEIGH,this);
		p.draw(g2);
		enermy.draw(g2);
		g2.setColor(Color.RED);
		g2.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g2.drawString("Score :"+p.score, 500, 45);
		hp.draw(g2);
		}
		if(end%2== 0) 
		{
		g2.setColor(Color.magenta);
		g2.setFont(new Font("TimesRoman", Font.BOLD, 70));
		g2.drawString("Game Over", 120, 100);
		}
	}
	
	public void loopstart() {
		loop = new Timer(10, this);
		loop.start();
	}
	
	public void loopstop() {
		loop.stop();
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println("test");
		p.update();
		if(end > 1){
		}
		else if(p.score > 30) {
			enermy.updat(3);
		}
		else if(p.score > 20) {
			enermy.updat(4);
		}
		else if(p.score > 10) {
		enermy.updat(3);
		}else {
			enermy.updat(2);
		}
		p.dumb();
		repaint();
		if(p.hp() == 0){
			end+=1;
			enermy.end+=1;
			enermy.clear();
			p.sethp(3);
		}
		
	}
	
}
