package snake;

import java.awt.*;
import java.util.Objects;

public class GraphicsWIN extends Graphics{

    public GraphicsWIN(Game g) {
        super(g);
    }

    public void paintComponent(java.awt.Graphics g) {


        Graphics2D g2d = (Graphics2D) g;

        Font currentFont = g2d.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);

        Color darkGreen = new Color(3, 163, 3);

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Game.width * Game.dimension + 5, Game.height * Game.dimension + 5);

        if(Objects.equals(state, "START")) {
            g2d.setColor(Color.white);
            g2d.setFont(newFont);
            g2d.drawString("Press Any Key", (float) Game.width / 2 * Game.dimension - currentFont.getSize() * 1.4F - 35, (float) Game.height / 2 * Game.dimension - currentFont.getSize() * 1.4F);
        }
        else if(Objects.equals(state, "RUNNING")) {
            g2d.setColor(Color.red); //ustawianie pozycji i koloru jabłka
            g2d.fillRect(f.getX() * Game.dimension, f.getY() * Game.dimension, Game.dimension, Game.dimension);

            g2d.setColor(Color.green);
            for(Rectangle r : s.getBody()) {    //ustawianie koloru ciała
                g2d.fill(r);
            }
            g2d.setColor(darkGreen);
            g2d.fill(s.getBody().get(0));   //ustawianie koloru głowy

            g2d.setColor(Color.WHITE);
            g2d.setFont(newFont);           //ustawianie napisu oraz jego koloru
            g2d.drawString("Score: " + (s.getBody().size() - 3), Game.dimension, Game.dimension);
            g2d.drawString("Highscore " + game.highScore, Game.dimension * Game.dimension, Game.dimension);


        }
        else {
            g2d.setColor(Color.RED);    //ustawianie koloru tekstu końcowego
            g2d.setFont(newFont);
            g2d.drawString("YOU LOST", Game.width/2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);

        }
    }
}
