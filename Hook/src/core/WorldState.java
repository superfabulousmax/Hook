package core;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Rectangle;

import entities.AbstractEntity;

/**
 * Contains current game state.
 * It knows how to update the game state.
 * It knows how to serialize(convert into a different data format)the game state into a network message.
 * It knows about collision too.
 * @author Sinead+Guy
 *
 */
public class WorldState {
	
	//things in the game world
	public List<AbstractEntity> entities;
	public List<Rectangle> collisionBoxes;
	

	public WorldState() {
		entities = new ArrayList<AbstractEntity>();
		collisionBoxes = new ArrayList<Rectangle>();
		//TODO testing
		Rectangle testBox = new Rectangle(200, 200, 100,100);
		collisionBoxes.add(testBox);
		collisionBoxes.add(new Rectangle(0, 500, 800, 100));
		collisionBoxes.add(new Rectangle(20, 450, 100, 50));
		collisionBoxes.add(new Rectangle(50, 360, 200, 50));
		
	}

	public void update(float delta) {
		for (AbstractEntity entity : entities)
			entity.update(delta,  this);
		
	}
}
