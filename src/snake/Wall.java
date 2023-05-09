package snake;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

public class Wall {
    private ArrayList<Rectangle> wallEasy;
    private ArrayList<Rectangle> wallHard;
    private int w = Game.width;
    private int h = Game.height;
    private int d = Game.dimension;

    public int[] lowerWallPosX = new int[17];
    public int lowerWallPosY = 180;
    public int[] upperWallPosX = new int[17];
    public int upperWallPosY = 420;

    public int[] leftUpperWallPosY = new int[5];
    public int[] leftLowerWallPosY = new int[5];
    public int[] rightUpperWallPosY = new int[5];
    public int[] rightLowerWallPosY = new int[5];
    public int leftVertWallPosX = 460;
    public int rightVertWallPosX = 120;

    public Wall() {}

    public ArrayList<Rectangle> getWallEasy() {
        wallEasy = new ArrayList<>();
        Rectangle tempE;

        //lower easy wall
        for(int i = 0; i < 17; i++){
            tempE = new Rectangle(d, d);
            tempE.setLocation((w - i - 8) * d, ((h / 2) * d) + (6 * d));
            lowerWallPosX[i] = (w - i - 8) * d;
            wallEasy.add(tempE);
        }

        //upper easy wall
        for(int i = 0; i < 17; i++){
            tempE = new Rectangle(d, d);
            tempE.setLocation((w - i - 8) * d, ((h / 2) * d) - (6 * d));
            upperWallPosX[i] = (w - i - 8) * d;
            wallEasy.add(tempE);
        }

        return wallEasy;
    }
    public ArrayList<Rectangle> getWallHard() {
        wallHard = new ArrayList<>();
        Rectangle tempH;

        //hard lower wall
        for(int i = 0; i < 17; i++){
            tempH = new Rectangle(d, d);
            tempH.setLocation((w - i - 8) * d, ((h / 2) * d) + (6 * d));
            lowerWallPosX[i] = (w - i - 8) * d;
            wallHard.add(tempH);
        }

        //hard upper wall
        for(int i = 0; i < 17; i++){
            tempH = new Rectangle(d, d);
            tempH.setLocation((w - i - 8) * d, ((h / 2) * d) - (6 * d));
            upperWallPosX[i] = (w - i - 8) * d;
            wallHard.add(tempH);
        }

        //hard left upper wall
        for(int i = 0; i < 5; i++){
            tempH = new Rectangle(d, d);
            tempH.setLocation((w - 24) * d, ((h / 2) * d) - (6 * d) + i * d);
            leftUpperWallPosY[i] = ((h / 2) * d) - (6 * d) + i * d;
            wallHard.add(tempH);
        }

        //hard left lower wall
        for(int i = 0; i < 5; i++){
            tempH = new Rectangle(d, d);
            tempH.setLocation((w - 24) * d, ((h / 2) * d) + (6 * d) - i * d);
            leftLowerWallPosY[i] = ((h / 2) * d) + (6 * d) - i * d;
            wallHard.add(tempH);
        }

        //hard right upper wall
        for(int i = 0; i < 5; i++){
            tempH = new Rectangle(d, d);
            tempH.setLocation((w - 7) * d, ((h / 2) * d) - (6 * d) + i * d);
            rightUpperWallPosY[i] = ((h / 2) * d) - (6 * d) + i * d;
            wallHard.add(tempH);
        }

        //hard right lower wall
        for(int i = 0; i < 5; i++){
            tempH = new Rectangle(d, d);
            tempH.setLocation((w - 7) * d, ((h / 2) * d) + (6 * d) - i * d);
            rightLowerWallPosY[i] = ((h / 2) * d) + (6 * d) - i * d;
            wallHard.add(tempH);
        }

        return wallHard;
    }
}
