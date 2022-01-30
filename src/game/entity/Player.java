package game.entity;

import game.data.GameState;
import game.io.AssetManager;
import game.io.KeyHandler;
import game.main.GamePanel;

public class Player extends Entity {

	KeyHandler keyH;

	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);

		this.keyH = keyH;

		setDefaultValues();
		setImage();
	}

	public void setDefaultValues() {

		x = 100;
		y = GamePanel.tileSize * (GamePanel.maxScreenRow - 1);
		width = GamePanel.tileSize;
		height = GamePanel.tileSize;

		speed = 4;

		solidArea.width = width;

		life = 3;
		direction = "left";

	}

	public void setImage() {

		spriteSheet = AssetManager.setSpriteSheet("/player/ridgeback", 32);
		left1 = spriteSheet.get(0);
		left2 = spriteSheet.get(1);
		right1 = spriteSheet.get(2);
		right2 = spriteSheet.get(3);
	}

	public void update() {

		if (keyH.leftPressed || keyH.rightPressed) {

			if (keyH.leftPressed == true) {
				direction = "left";
				if (x > 0) {
					x -= speed;
				}
			} else if (keyH.rightPressed == true) {
				direction = "right";
				if (x < (GamePanel.screenWidth - (GamePanel.tileSize))) {
					x += speed;
				}
			}

			spriteCounter++;
			if (spriteCounter > 10) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}

		}

		if (life <= 0) {
			gp.gameState = GameState.OVER;
			gp.stopBackgroundMusic();
			gp.playSoundEffect(4);
		}

		int objIndex = gp.cChecker.checkObject(this, true);
		HitObject(objIndex);

		// dumb();

	}

	public void HitObject(int i) {

		if (i != 999) {
			if (gp.obj.get(i).getClass().getSimpleName().equals("Ruby")) {
				gp.obj.get(i).soundEffect();
				gp.score++;
				gp.obj.remove(i);
			} else if (gp.obj.get(i).getClass().getSimpleName().equals("Heart")) {
				if (life < 3) {
					gp.obj.get(i).soundEffect();
					life++;
				}
				gp.obj.remove(i);
			} else if (gp.obj.get(i).y > GamePanel.screenHeight) {
				gp.obj.remove(i);
			}

		}

	}

}
