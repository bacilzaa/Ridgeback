package game.entity;

import game.io.AssetManager;
import game.main.GamePanel;


public class Heart extends Entity{
	
	
	
	public Heart(GamePanel gp,int x,int speed) {
		super(gp);
		this.x = x;
		this.speed = speed;
		obj = AssetManager.setImage("/image/heart");
		sound = 3;
	}
	
	public void update() {
		y+= speed;
	}
	
}
