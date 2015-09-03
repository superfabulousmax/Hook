package core;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Runs the game states.
 * @author Sinead+Guy
 * 
 */
public class Game extends StateBasedGame {

	public Game(String title) {
		
		super(title);
	}
	
	/**
	 * Initialize the different states of the game
	 */
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
	
		addState(new states.GameState());
		enterState(0);//this is game state ID
		
	}
}
