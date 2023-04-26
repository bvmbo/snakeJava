package snake;

import java.awt.event.*;
import javax.swing.*;

public abstract class Graphics
extends JPanel
implements ActionListener{
	public String state;

	protected Snake s;
	protected Food f;
	protected Game game;

	private Timer t = new Timer(100, this);

	public Graphics(Game g) {
		t.start();
		state = "START";

		game = g;
		s = g.getPlayer();
		f = g.getFood();

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
