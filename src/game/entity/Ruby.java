package game.entity;

import game.io.AssetManager;
import game.main.GamePanel;

public class Ruby extends Entity {

	public Ruby(GamePanel gp, int x, int speed) {
		super(gp);
		this.x = x;
		this.speed = speed;

		obj = AssetManager.setImage("/image/ruby");
		sound = "/sound/Bark";
		
	}

	public void update() {

		y += speed;

		if (y > gp.screenHeight) {
			gp.player.life--;
		}

	}
}
