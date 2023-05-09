package snake;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Wall {
    private ArrayList<Rectangle> body;
    private int w = Game.width;
    private int h = Game.height;
    private int d = Game.dimension;


    public Wall() {
        body = new ArrayList<>();

        Rectangle temp;

        for(int i = 0; i < 17; i++){
            temp = new Rectangle(d, d);
            temp.setLocation((w - i - 8) * d, (h / 2) * d + 6 * d);
            body.add(temp);
        }

        for(int i = 0; i < 17; i++){
            temp = new Rectangle(d, d);
            temp.setLocation((w - i - 8) * d, (h / 2) * d - 6 * d);
            body.add(temp);
        }



//        temp = new Rectangle(d, d);
//        temp.setLocation((w / 2 - 1) * d, (h / 2) * d + 6 * d);
//        body.add(temp);
//
//        temp = new Rectangle(d, d);
//        temp.setLocation((w / 2 - 2) * d, (h / 2) * d + 6 * d);
//        body.add(temp);

    }

    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public int getX() {
        return body.get(0).x;
    }

    public int getY() {
        return body.get(0).y ;
    }
}
