package snake;

import java.awt.*;
import java.util.Objects;

public class GraphicsMedium extends Graphics{

    public GraphicsMedium(Game g) {
        super(g);
    }

    public void paintComponent(java.awt.Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        Font currentFont = g2d.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);

        boolean c = false;

        for(int i = 0; i < Game.height * Game.dimension; i += 20){
            for(int j = 0; j < Game.width * Game.dimension; j += 20){
                if(c){
                    g2d.setColor(boardGreen);
                    g2d.fillRect(i, j, Game.dimension, Game.dimension);
                    c = !c;
                } else {
                    g2d.setColor(boardDarkerGreen);
                    g2d.fillRect(i, j, Game.dimension, Game.dimension );
                    c = !c;
                }
            }
            c = !c;
        }

        /*g2d.setColor(Color.blue);
        g2d.fillRect(Game.dimension, 0, Game.dimension,  Game.dimension );*/  //dodawanie klocków

        if(Objects.equals(state, "START")) {
            g2d.setColor(Color.BLACK);
            g2d.setFont(newFont);
            g2d.drawString("Press Any Key", (float) Game.width / 2 * Game.dimension - currentFont.getSize() * 1.4F - 35, (float) Game.height / 2 * Game.dimension - currentFont.getSize() * 1.4F);
        }
        else if(Objects.equals(state, "RUNNING")) {
            g2d.setColor(Color.red); //ustawianie pozycji i koloru jabłka
            g2d.fillRect(f.getX() * Game.dimension, f.getY() * Game.dimension, Game.dimension, Game.dimension);

            g2d.setColor(snakeBodyBlue);
            for(Rectangle r : s.getBody()) {    //ustawianie koloru ciała
                g2d.fill(r);
            }
            g2d.setColor(snakeHeadBlue);
            g2d.fill(s.getBody().get(0));   //ustawianie koloru głowy

            g2d.setColor(wallColor);
            for(Rectangle r : wall.getWallMedium()) {
                g2d.fill(r);
            }
//            g2d.fill(wall.getWallMedium());

            g2d.setColor(Color.BLACK);
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
