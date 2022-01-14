package game.UI;

import static game.main.GamePanel.screenHeight;
import static game.main.GamePanel.screenWidth;
import static game.main.GamePanel.tileSize;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Random;

import game.data.GameState;
import game.entity.Heart;
import game.entity.Ruby;
import game.io.AssetManager;
import game.main.GamePanel;

public class UI {

	GamePanel gp;
	Graphics2D g2;

	BufferedImage heart;

	Random rand = new Random();

	public UI(GamePanel gp) {
		this.gp = gp;

		heart = AssetManager.setImage("/image/heart");
	}

	public void update() {

		if (gp.gameState == GameState.START) {

			gp.player.update();

			for (int i = 0; i < gp.obj.size(); i++) {
				if (gp.obj.get(i) != null) {
					gp.obj.get(i).update();

					if (gp.obj.get(i).y > screenHeight) {
						gp.obj.remove(i);
					}
				}

			}

			if (gp.tick >= 10) {
				if (rand.nextInt(100) == 20) {
					gp.obj.add(new Heart(gp, rand.nextInt(screenWidth - tileSize), 3));
				}
				gp.obj.add(new Ruby(gp, rand.nextInt(screenWidth - tileSize), 2));
				
				gp.tick = 0;
			}

		} else {
			gp.obj.clear();
		}

	}

	public void draw(Graphics2D g2) {
		this.g2 = g2;

		drawBackground();

		drawPlayerLife();
		drawScore();

		if (gp.gameState == GameState.START) {

			gp.player.draw(g2);

			for (int i = 0; i < gp.obj.size(); i++) {
				if (gp.obj.get(i) != null) {
					gp.obj.get(i).draw(g2);
//					g2.setColor(Color.white);
//					g2.drawRect(gp.obj.get(i).x, gp.obj.get(i).y,gp.obj.get(i).solidArea.width, gp.obj.get(i).solidArea.height);
				}
			}
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

	public void drawScore() {

		g2.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g2.setColor(Color.white);
		g2.drawString("Score :" + gp.score, screenWidth - (tileSize * 2), tileSize / 2);
	}

	public void drawBackground() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage(getClass().getResource("/image/bg.gif"));

		g2.drawImage(image, 0, 0, screenWidth, screenHeight, null);
	}

}
