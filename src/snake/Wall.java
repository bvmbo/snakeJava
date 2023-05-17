package snake;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

public class Wall {
    private int h = Game.height;
    private int d = Game.dimension;

    public Wall() {}

    public Rectangle[] getWallMedium() {
        Rectangle[] r = new Rectangle[2];

        r[0] = new Rectangle(d * 15, d);
        r[0].setLocation(h / 2 * d - 8 * d, 9 * d);

        r[1] = new Rectangle(d * 15, d);
        r[1].setLocation(h / 2 * d - 8 * d, ((h / 2) * d) + (6 * d));

        return r;
    }
    public Rectangle[] getWallHard() {
        Rectangle[] r = new Rectangle[6];

        r[0] = new Rectangle(d * 15, d); // lower wall
        r[0].setLocation(h /2 * d - 8 * d, 9 * d);

        r[1] = new Rectangle(d * 15, d); // upper wall
        r[1].setLocation(h /2 * d - 8 * d, ((h / 2) * d) + (6 * d));

        r[2] = new Rectangle(d, d * 5); // left upper wall
        r[2].setLocation(6 * d,9 * d);

        r[3] = new Rectangle(d, d * 5); // left lower wall
        r[3].setLocation(6 * d,17 * d);

        r[4] = new Rectangle(d, d * 5); // right upper wall
        r[4].setLocation(21 * d, 9 * d);

        r[5] = new Rectangle(d, d * 5); // right lower wall
        r[5].setLocation(21 * d, 17 * d);

        return r;
    }
}
