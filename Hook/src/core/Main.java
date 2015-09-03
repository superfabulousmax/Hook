package core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 * Launches the game.
 * @author Sinead+Guy
 *
 */
public class Main {
	public static void main(String[] args) {
		try {
			AppGameContainer container = new AppGameContainer(new Game("Hook"));
			container.setDisplayMode(800, 600, false);
			container.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}
	}
}
