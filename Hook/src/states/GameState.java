package states;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.WorldState;
import entities.AbstractEntity;
import entities.PlayerEntity;

/**
 * Runs an instance of the actual game.
 * @author Sinead+Guy
 *
 */
public class GameState extends BasicGameState{
	
	private WorldState worldState;
	

	/**
	 * when the game intializes
	 */
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		worldState = new WorldState();
		//populate world state entities
		worldState.entities.add(new PlayerEntity(0, 0, container.getInput(), worldState));
		
	}
	
	/**
	 * Renders the game states
	 */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics graphics)
			throws SlickException {
		//render the entities
		graphics.setColor(Color.white);
		for(AbstractEntity entity: worldState.entities)
			entity.render(graphics);
		
		//debug render of all collison boxes in red
		graphics.setColor(Color.red);
		for(Rectangle collisionBox: worldState.collisionBoxes)
			graphics.draw(collisionBox);
		
		
	}
	
	/**
	 * updates the game states
	 * @param delta time in milliseconds
	 */
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		float deltaF = delta / 1000.0f;//time in seconds
		
		worldState.update(deltaF);
		
		
	}

	@Override
	public int getID() {
		
		return 0;
	}

}
