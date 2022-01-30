package game.entity;

import static game.main.GamePanel.screenHeight;
import static game.main.GamePanel.screenWidth;
import static game.main.GamePanel.tileSize;

import game.main.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Entity {

	GamePanel gp;

	// DEFUALT STATUS
	public int x = 0, y = 0, width = tileSize / 2, height = tileSize / 2;

	// IMAGE
	public ArrayList<BufferedImage> spriteSheet = new ArrayList<BufferedImage>();
	public BufferedImage left1, left2, right1, right2, obj;
	public String direction = "defualt";
	
	// SOUND
	public Integer sound = 999;

	// SPRITE ANIMATE
	public int spriteCounter = 0;
	public int spriteNum = 1;

	// COLLISION
	public Rectangle solidArea = new Rectangle(0, 0, tileSize / 2, tileSize / 2);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;

	public boolean collisionOn = false;

	// CHARECTER STATUS
	public int life;
	public int speed;

	public Entity(GamePanel gp) {
		this.gp = gp;
	}

	public void draw(Graphics2D g2) {

		if (y < screenHeight && x < screenWidth) {

			BufferedImage image = null;

			switch (direction) {
			case "left":
				switch (spriteNum) {
				case 1:
					image = left1;
					break;
				case 2:
					image = left2;
					break;
				}
				break;
			case "right":
				switch (spriteNum) {
				case 1:
					image = right1;
					break;
				case 2:
					image = right2;
					break;
				}

			default:
				if (obj != null) {
					image = obj;
				}
				break;
			}

			g2.drawImage(image, x, y, width, height, null);

		}

	}

	public void update() {

	}

	public void soundEffect() {
		if (sound != 999) {
			gp.playSoundEffect(sound);
		}
	}

}
