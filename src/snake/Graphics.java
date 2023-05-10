package snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class Graphics extends JPanel implements ActionListener{
	public String state;

	protected Snake s;
	protected Food f;
	protected Game game;
	protected Wall wall;

	protected Color snakeBodyBlue = new Color(69,114,231);
	protected Color snakeHeadBlue = new Color(48, 77, 156);
	protected Color boardDarkerGreen = new Color(170,215, 81);
	protected Color boardGreen = new Color(162, 209, 73);
	protected Color wallColor = new Color(225, 152, 31);

	private Timer t = new Timer(100, this);

	public Graphics(Game g) {
		t.start();
		state = "START";

		game = g;
		s = g.getPlayer();
		f = g.getFood();

		wall = g.getWall();

		if(g.highScore.equals("")){
			g.highScore = g.getHighScore();
		}

		this.addKeyListener(g);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}

	abstract public void paintComponent(java.awt.Graphics g); //POLIMORFIZM

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		game.update();
	}
}
