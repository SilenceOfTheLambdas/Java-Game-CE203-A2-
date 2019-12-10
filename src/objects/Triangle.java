package objects;

import java.awt.*;

public class Triangle extends Shapes {
    public Triangle(Graphics g, int x, int y, int x1, int y1) {
        super(g, x, y, x1, y1);
    }

    @Override
    void setType() {
        this.type = this;
    }

    @Override
    Shapes getShape() {
        return this;
    }

    @Override
    void drawShape(Graphics g, int x, int y, int x1, int y1) {
        g.fillPolygon(new int[] {10, 20, 30}, new int[] {30, 20, 30}, 3);
    }
}
