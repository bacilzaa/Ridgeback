package gametest;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class JavaGame extends JFrame{
	
	public static final int WIDTH = 640;
	public static final int HEIGH = 480;
	Dimension size= new Dimension(WIDTH,HEIGH);
	public JavaGame(){
		super("2D Game");
		getContentPane().setBackground(Color.WHITE);
		setSize(size);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		//add(new test());
		GameScene gameScene = new GameScene();
		gameScene.setBackground(Color.BLACK);
		getContentPane().add(gameScene);
		PlaySound();
	}
	
	static void PlaySound() {
		try {
			Clip c = AudioSystem.getClip();
			c.open(AudioSystem.getAudioInputStream(new File("C:\\\\Users\\\\Sinner\\\\Desktop\\\\java pro\\\\bgs.wav")));
			c.start();
			c.loop(Clip.LOOP_CONTINUOUSLY);
			long cTimePosition = c.getLongFramePosition();
			//c.stop();
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
