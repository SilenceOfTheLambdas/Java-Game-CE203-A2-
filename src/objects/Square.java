package objects;

import java.awt.*;

public class Square extends Shapes {

    public Square(Graphics g, int x, int y, int x1, int y1) {
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
        g.fillRect(x, y, x1, y1);
    }
}
