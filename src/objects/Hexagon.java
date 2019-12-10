package objects;

import java.awt.Graphics;

/**
 * Hexagon
 */
public class Hexagon extends Shapes {

    public Hexagon(Graphics g, int x, int y, int x1, int y1) {
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
        
    }

    
}