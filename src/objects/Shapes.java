package objects;

import java.awt.*;

public abstract class Shapes {

    public Shapes type;
    public int x;
    public int y;

    public Shapes(Graphics g, int x, int y, int x1, int y1) {
        drawShape(g, x, y, x1, y1);
    }

    abstract void setType();

    abstract Shapes getShape();
    abstract void drawShape(Graphics g, int x, int y, int x1, int y1);
}
