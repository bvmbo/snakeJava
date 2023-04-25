package snake;

import java.awt.Rectangle;

public class Food {
	private int x;
	private int y;

	public Food(){}
	
	public Food(Snake player) {
		this.random_spawn(player);
	}
	
	public void random_spawn(Snake player) {
		boolean onSnake = true;
		while(onSnake) {
			onSnake = false;
			
			x = (int)(Math.random() * Game.width - 1);
			y = (int)(Math.random() * Game.height - 1);
			
			for(Rectangle r : player.getBody()){ //TODO can be changed to not allow to spawn food on a player
				if(r.x == x && r.y == y) {
					onSnake = true;
				}
			}
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
