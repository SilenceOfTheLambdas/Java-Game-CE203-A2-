package objects;

import java.awt.*;

public class Circle extends Shapes {

    public Circle(Graphics g, int x, int y, int x1, int y1) {
        super(g, x, y, x1, y1);
    }

    @Override
    void setType() {
//        This will set the type of shape to draw
        type = this;
    }

    @Override
    Shapes getShape() {
        return this;
    }

    @Override
    void drawShape(Graphics g, int x, int y, int x1, int y1) {
        g.fillOval(x, y, x1, y1);
    }

}
