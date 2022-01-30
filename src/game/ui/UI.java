package game.ui;

import static game.main.GamePanel.screenHeight;
import static game.main.GamePanel.screenWidth;
import static game.main.GamePanel.tileSize;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import game.data.GameState;
import game.entity.Heart;
import game.entity.Ruby;
import game.io.AssetManager;
import game.io.KeyHandler;
import game.main.GamePanel;

public class UI {

	GamePanel gp;
	Graphics2D g2;
	
	Font canvasBags;
	
	private KeyHandler keyH;

	BufferedImage heart;

	Random rand = new Random();

	public UI(GamePanel gp , KeyHandler keyH) {
		this.gp = gp;
		this.keyH =keyH;
		heart = AssetManager.setImage("/image/heart");
		
		try {
			InputStream is = getClass().getResourceAsStream("/font/CanvasBags-ZrqB.ttf");
			canvasBags = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void update() {

		if (gp.gameState == GameState.START) {
			gp.playBackgroundMusic(1);
			gp.player.update();

			for (int i = 0; i < gp.obj.size(); i++) {
				if (gp.obj.get(i) != null) {
					gp.obj.get(i).update();

					if (gp.obj.get(i).y > screenHeight) {
						gp.obj.remove(i);
					}
				}

			}
			
			spawnObject();

		}
		
		if (gp.gameState == GameState.OVER) {
			gp.obj.clear();
			if(keyH.spacePressed) {
				gp.score = 0;
				gp.player.setDefaultValues();
				gp.gameState = GameState.START;
			}
		}

	}

	public void draw(Graphics2D g2) {
		this.g2 = g2;
		
		g2.setFont(canvasBags);

		if (gp.gameState == GameState.START) {
			
			
			drawBackground();

			drawPlayerLife();
			drawScore();
			

			gp.player.draw(g2);

			for (int i = 0; i < gp.obj.size(); i++) {
				if (gp.obj.get(i) != null) {
					gp.obj.get(i).draw(g2);
				}
			}
		}
		
		if (gp.gameState == GameState.OVER) {
			drawGameOver();
		}

	}

	public void drawPlayerLife() {

		int x = tileSize / 2;
		int y = tileSize / 3;
		int i = 0;

		while (i < gp.player.life) {
			g2.drawImage(heart, x, y, null);
			i++;
			x += tileSize / 3;
		}

	}
	
	public void drawGameOver() {
		
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,50F));
		g2.setColor(Color.yellow);
		g2.drawString("GAME OVER", screenWidth/2 - (tileSize), screenHeight / 2 - (tileSize/2));;
		g2.setColor(Color.white);
		g2.drawString("Score :" + gp.score, screenWidth/2 - (tileSize), screenHeight / 2);
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,50F));
		
		g2.setColor(Color.MAGENTA);
		g2.drawString("Press Space to Play again", tileSize*2, screenHeight / 2 + tileSize);
	}

	public void drawScore() {

		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,24F));
		g2.setColor(Color.white);
		g2.drawString("Score :" + gp.score, screenWidth - (tileSize * 2), tileSize / 2);
	}

	public void drawBackground() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(getClass().getResource("/image/bg.gif"));

		g2.drawImage(image, 0, 0, screenWidth, screenHeight, null);
	}
	
	private void spawnObject() {
		
		if (gp.tick >= 20) {
			if (rand.nextInt(100) > 80) {
				gp.obj.add(new Heart(gp, rand.nextInt(screenWidth - tileSize), 3));
			}
			gp.obj.add(new Ruby(gp, rand.nextInt(screenWidth - tileSize), 2));

			gp.tick = 0;
		}
	}

}
