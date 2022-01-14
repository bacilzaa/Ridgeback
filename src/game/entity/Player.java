package game.entity;

import game.data.GameState;
import game.io.AssetManager;
import game.io.KeyHandler;
import game.io.Sound;
import game.main.GamePanel;
import game.util.collectEn;

public class Player extends Entity {

	KeyHandler keyH;
	collectEn enhp;

	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);

		this.keyH = keyH;

		setDefaultValues();
		setImage();
	}

	public void setDefaultValues() {

		x = 100;
		y = gp.tileSize * (gp.maxScreenRow - 1);
		width = gp.tileSize;
		height = gp.tileSize;

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
				if (x < (gp.screenWidth - (gp.tileSize))) {
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
		}

		int objIndex = gp.cChecker.checkObject(this, true);
		pickUpObject(objIndex);

		// dumb();

	}

	public void pickUpObject(int i) {

		if (i != 999) {
			if (gp.obj.get(i).getClass().getSimpleName().equals("Ruby")) {
				gp.obj.get(i).soundEffect();
				gp.score++;
				gp.obj.remove(i);
			} else if (gp.obj.get(i).getClass().getSimpleName().equals("Heart")) {
				life++;
				gp.obj.remove(i);
			}

		}

	}

}
