package game.main;

import javax.swing.JPanel;

import game.UI.UI;
import game.data.GameState;
import game.entity.Entity;
import game.entity.Player;
import game.io.KeyHandler;
import game.io.Sound;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 8426044819472036419L;

	// SCREEN SETTING
	final static int originalTileSize = 16; // 16 x 16 tile
	final static int scale = 6;

	public static final int tileSize = originalTileSize * scale; // 96 x 96 tile
	public static final int maxScreenCol = 8;
	public static final int maxScreenRow = 6;
	public static final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	public static final int screenHeight = tileSize * maxScreenRow;// 576 pixels

	public int gameState = GameState.START;

	public int score = 0;

	final int maxTickPerSec = 20;
	public int tick = 0;

	final int FPS = 60;

	// SYSTEM
	KeyHandler keyH = new KeyHandler();
	public Sound sound = new Sound();
	public CollisionChecker cChecker = new CollisionChecker(this);

	UI ui = new UI(this);

	Thread gameThread;

	public Player player = new Player(this, keyH);
	public ArrayList<Entity> obj = new ArrayList<Entity>();

	public GamePanel() {

		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);

		this.addKeyListener(keyH);
		setFocusable(true);

		// hp = new collectEn();
		setLayout(null);

		sound.backgroundMusic("/sound/bgs");
	}

	public void startGameThread() {

		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		double secToNano = 1000000000;

		double drawInterval = secToNano / FPS; // 0.01666 seconds

		double tickInterval = secToNano / maxTickPerSec;

		double alpha = 0;
		double delta = 0;

		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (gameThread != null) {

			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			alpha += (currentTime - lastTime) / tickInterval;
			timer += (currentTime - lastTime);

			lastTime = currentTime;

			if (delta >= 1) {
				ui.update();
				repaint();
				delta--;
				drawCount++;
			}

			if (alpha >= 1) {
				tick++;
				alpha--;
			}

			if (timer >= secToNano) {

				System.out.println("TICK " + tick);
				System.out.println("FPS" + drawCount);

				drawCount = 0;
				timer = 0;

			}

		}

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.WHITE);
		g2.setColor(Color.DARK_GRAY);
		
		ui.draw(g2);
		

		g2.dispose();

	}

}
