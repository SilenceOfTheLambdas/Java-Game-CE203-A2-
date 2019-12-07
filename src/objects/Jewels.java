package objects;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public abstract class Jewels extends JPanel {
//    TODO: this will contain some methods for creating various jewel shapes

    Color jewel_color; // The colour of the jewel
    int[][] position; // The position of the jewel on the game_grid
    RectangularShape shape;

    public abstract void get_jewel_color();
    public abstract void get_jewel_shape();
    public abstract void get_jewel_position();
}
