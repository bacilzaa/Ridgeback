package game.main;

import game.entity.Entity;

public class CollisionChecker {

	GamePanel gp;

	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}

	public int checkObject(Entity entity, Boolean player) {

		
		int index = 999;
		
		for(int i = 0; i < gp.obj.size(); i++) {
			
			
			
			if(gp.obj.get(i) != null) {
				
				
				// Get entity's solid area position;
				entity.solidArea.x = entity.x + entity.solidArea.x;
				entity.solidArea.y = entity.y + entity.solidArea.y;
				
				gp.obj.get(i).solidArea.x =	 gp.obj.get(i).x+gp.obj.get(i).solidArea.x;
				gp.obj.get(i).solidArea.y =	 gp.obj.get(i).y+gp.obj.get(i).solidArea.y;
				
				if(entity.solidArea.intersects(gp.obj.get(i).solidArea)) {
					
					System.out.println("HIT!");
					
					if(player == true) {
						index = i;
					}
				}
				
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				
				gp.obj.get(i).solidArea.x = gp.obj.get(i).solidAreaDefaultX;
				gp.obj.get(i).solidArea.y = gp.obj.get(i).solidAreaDefaultY;
				
				
				
			}
			
			
		}
		
		return index;

	}

}
