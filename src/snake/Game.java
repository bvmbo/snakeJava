package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Objects;

import javax.sound.sampled.*;
import javax.swing.*;

public class Game implements KeyListener {
	private final Snake player;
	private final Food food;
	private final Graphics graphics;

	protected String highScore = "";

	public static final int width = 30;
	public static final int height = 30;
	public static final int dimension = 20;

	public Game() {
		JFrame window = new JFrame();
		player = new Snake();
		food = new Food(player);
		graphics = new GraphicsWIN(this); //tworzenie instancji typu Graphics POLIMORFIZM
		window.add(graphics);

		window.setTitle("Snake");
		window.setSize(width * dimension + 2, height * dimension + dimension + 4);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void start() {
		graphics.state = "RUNNING";
		if(highScore.equals("")){
			highScore = this.getHighScore();
		}
	}

	public void update() {
		if (Objects.equals(graphics.state, "RUNNING")) {
			if (check_food_collision()) {
				playSound();
				player.grow();
				food.random_spawn(player);
			} else if (check_wall_collision() || check_self_collision()) {
				graphics.state = "END";
			} else {
				player.move();
			}
		}
	}

	private boolean check_wall_collision() {
		if (player.getX() < 0 || player.getX() > width * dimension
				|| player.getY() < 0 || player.getY() > height * dimension) {
			checkScore();
			return true;
		}
		return false;
	}

	private boolean check_food_collision() {
		if (player.getX() == food.getX() * dimension && player.getY() == food.getY() * dimension) {
			return true;
		}
		return false;
	}

	private boolean check_self_collision() {
		for (int i = 1; i < player.getBody().size(); i++) {
			if (player.getX() == player.getBody().get(i).x && player.getY() == player.getBody().get(i).y) {
				checkScore();
				return true;
			}
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		if (graphics.state == "RUNNING") {
			if (keyCode == KeyEvent.VK_W && player.getMove() != "DOWN") {
				player.up();
			}

			if (keyCode == KeyEvent.VK_S && player.getMove() != "UP") {
				player.down();
			}

			if (keyCode == KeyEvent.VK_A && player.getMove() != "RIGHT") {
				if (player.getMove() == "NOTHING") {
					return;
				}
				player.left();
			}

			if (keyCode == KeyEvent.VK_D && player.getMove() != "LEFT") {
				player.right();
			}

		} else {
			this.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public Snake getPlayer() {
		return player;
	}

	public Food getFood() {
		return food;
	}

	private void playSound() {
		try {
			File soundPath = new File("sound/sound2.wav");

			if (soundPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			} else {
				System.out.println("No file");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkScore() {
		int score = player.getBody().size() - 3;
		if (score > Integer.parseInt(highScore.split(":")[1])) {
			String name = JOptionPane.showInputDialog("You set a new highscore. What is your name?");
			highScore = name + ":" + score;

			File scoreFile = new File("highScores/highscore.dat");
			if (!scoreFile.exists()) {
				try {
					scoreFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			FileWriter writeFile;
			BufferedWriter writer = null;

			try {
				writeFile = new FileWriter(scoreFile);
				writer = new BufferedWriter(writeFile);
				writer.write(this.highScore);
			} catch (Exception e) {} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (Exception e) {}
				}
			}
		}
	}

	public String getHighScore() {
		FileReader readFile;
		BufferedReader reader = null;

		try {
			readFile = new FileReader("highScores/highscore.dat");
			reader = new BufferedReader(readFile);
			return reader.readLine();
		} catch (Exception e) {
			return "Nobody:0";
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
