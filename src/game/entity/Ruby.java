package game.entity;

import game.io.AssetManager;
import game.main.GamePanel;

public class Ruby extends Entity {

	public Ruby(GamePanel gp, int x, int speed) {
		super(gp);
		this.x = x;
		this.speed = speed;

		obj = AssetManager.setImage("/image/ruby");
		sound = 0;
		
	}

	public void update() {

		y += speed;

		if (y > GamePanel.screenHeight) {
			gp.player.life--;
			gp.playSoundEffect(2);
		}

	}
}
