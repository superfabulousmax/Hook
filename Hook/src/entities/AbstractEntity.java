package entities;

import org.newdawn.slick.Graphics;

import core.WorldState;

/**
 * Any kind of in game entity 
 * e.g. player, projectile, grappling hook etc.
 * @author Sinead+Guy
 *
 */
public abstract class AbstractEntity {
	//-------Fields--------//
	
	//entity position - centre of entity
	float x, y;
	
	//------methods-------//
	
	public AbstractEntity(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * renders this entity to the screen
	 * @param graphics the current graphics reference
	 */
	public abstract void render(Graphics graphics);
	
	/**
	 * updates this entity
	 * @param delta time since the last update in seconds
	 * @param world the current game state
	 */
	public abstract void update(float delta, WorldState world);
	
}
