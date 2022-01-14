package game.util;

import java.awt.Graphics2D;
import java.util.ArrayList;

import game.entity.Entity;

public class EntityGroup {

	public ArrayList<Entity> entityGroup = new ArrayList<Entity>();

	public void draw(Graphics2D g2) {
		for (int i = 0; i < entityGroup.size(); i++) {
			if(entityGroup.get(i) != null) {
				entityGroup.get(i).draw(g2);
			}

		}
	}

	public void update(int s) {
		for (int i = 0; i < entityGroup.size(); i++) {
			if(entityGroup.get(i) != null) {
				entityGroup.get(i).update();
			}

		}

	}

	public void addEntity(Entity entity) {
		entityGroup.add(entity);
	}

	public void removeEnemy(Entity entity) {
		entityGroup.remove(entity);
	}

	public Entity getEntity(int index) {
		return entityGroup.get(index);
	}

	public void clear() {
		entityGroup.clear();
	}

}
