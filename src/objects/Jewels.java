package objects;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public abstract class Jewels extends Rectangle2D {
//    TODO: this will contain some methods for creating various jewel shapes

    Color jewel_color; // The colour of the jewel
    int[][] position; // The position of the jewel on the game_grid
    RectangularShape shape;

    Jewels(RectangularShape shape, Color color) {
        this.shape = shape;
        this.jewel_color = color;
    }

    abstract void get_jewel_color();
    abstract void get_jewel_shape();
    abstract void get_jewel_position();
}
