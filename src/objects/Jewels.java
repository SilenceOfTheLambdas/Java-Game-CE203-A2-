package objects;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public abstract class Jewels extends JPanel {

    public Color jewelColor;
    public static final int JEWEL_X = 10;
    public static final int JEWEL_Y = 10;
    public static final int JEWEL_HEIGHT = 25;
    public static final int JEWEL_WIDTH = 25;

    public enum Shapes {
        Circle,
        Square;

        private static final java.util.List<Shapes> VALUES = List.of(values());
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static Shapes randomShape() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }

    public abstract Color get_jewel_color();
    public abstract void setJewelColor();

    public int getHeight() {
        return JEWEL_HEIGHT;
    }

    public int getWidth() {
        return JEWEL_WIDTH;
    }

    public int getX() {
        return JEWEL_X;
    }

    public int getY() {
        return JEWEL_Y;
    }
}
