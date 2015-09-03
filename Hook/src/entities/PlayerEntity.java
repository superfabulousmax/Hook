package entities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import core.WorldState;

/**
 * Manage and update the player.
 * @author Sinead+Guy
 *
 */
public class PlayerEntity extends AbstractEntity {
	//hit box for player
	Rectangle playerBoundary;
	Rectangle footBoundary; //for jumping
	
	//player velocity
	float vx, vy;
	Input input;
	
	//gravity
	public static final float GRAVITY = 200f;
	
	public PlayerEntity(float x, float y, Input input, WorldState world) {
		super(x, y);
		
		vx = 0;
		vy = 0;
		this.input = input;
		this.playerBoundary = new Rectangle(x-10, y-10, 20, 20);
		this.footBoundary = new Rectangle(x-10, y+10, 20, 5);
		
		//add player boundary hit box to world collsion box collection
		world.collisionBoxes.add(playerBoundary);
	}

	@Override
	public void render(Graphics graphics) {
		graphics.draw(playerBoundary);
		graphics.draw(footBoundary);
	}

	@Override
	public void update(float delta, WorldState world) {
		//jumping
		if (input.isKeyDown(Input.KEY_UP) && Math.abs(vy) <= 0.01f)
			if (checkCollision(world) == 1)
				vy = -200.0f;
		
		//add a gravitational fx
		vy += GRAVITY*delta;
		
		//clamp velocity
		vx = clamp(vx, 0, 400);
		vy = clamp(vy, 0, 400);
		
		//add a velocity f(x)
		float dx = vx * delta;
		float dy = vy * delta;
		
		//moving left and right
		if (input.isKeyDown(Input.KEY_LEFT)) dx -= delta * 200;
		if (input.isKeyDown(Input.KEY_RIGHT)) dx += delta * 200;

		movePlayerWithCollision(dx, dy, world);
	}

	/**
	 * checks whether there is a collison
	 * returns 0 if no collision, 1 if only foot collision, 2 if only body collision, 3 if both
	 */

	public int checkCollision(WorldState world)
	{
		for(Rectangle collisionBox: world.collisionBoxes)
		{
			//check first this not this class collsion box
			if(collisionBox != playerBoundary)
			{
				if(collisionBox.intersects(playerBoundary)) {
					if (collisionBox.intersects(footBoundary))
						return 3;
					return 2;
				}
				
				if (collisionBox.intersects(footBoundary))
					return 1;
			}
		}
		return 0;
	}

	/**
	 * Move the player and collision box the given deltas
	 */
	public void movePlayer(float dx, float dy) {
		this.x += dx;
		this.y += dy;
		
		//player x and y is the centre, we need absolute x y for the boundary boxes
		playerBoundary.setX(this.x - 10);
		playerBoundary.setY(this.y - 10);
		footBoundary.setX(this.x - 10);
		footBoundary.setY(this.y + 10);
	}
	
	/**
	 * checks whether the player can move
	 * and moves if player can. If player can't, binary search till they can.
	 */
	public void movePlayerWithCollision(float dx, float dy, WorldState world)
	{
		movePlayer(dx, 0);
		if (checkCollision(world) > 1) {
			movePlayer(-dx, 0);
			this.vx = 0;
		}

		movePlayer(0, dy);
		if (checkCollision(world) > 1) {
			movePlayer(0, -dy);
			this.vy = 0;
		}
	}

	/**
	 * clamps the given float to the given max and min magnitudes.
	 * respects sign.
	 */
	public float clamp(float x, float min, float max) {
		float mag = Math.abs(x);
		float sign = x < 0 ? -1 : 1;
		
		if (mag < min) return sign*min;
		if (max > max) return sign*max;
		return x;
	}
}
