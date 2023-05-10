package snake;

import java.awt.Rectangle;

public class Food {
	private int x;
	private int y;
	private final Wall wall = new Wall();
	private final Rectangle[] mediumWall = wall.getWallMedium();
	private final Rectangle[] hardWall = wall.getWallHard();
	private final Rectangle f = new Rectangle(20,20);

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
			f.setLocation(x * 20, y * 20);

			for(Rectangle r : player.getBody()){
				if(r.x == x && r.y == y) {
					onSnake = true;
				}
			}

			for(Rectangle r : mediumWall){
				if(r.getBounds().intersects(f)){
					onSnake = true;
				}
			}

			for(Rectangle r : hardWall){
				if(r.getBounds().intersects(f)){
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

	public Rectangle getF(){
		return f;
	}
}
