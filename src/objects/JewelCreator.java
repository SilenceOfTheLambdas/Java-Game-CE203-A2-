package objects;

import javax.swing.*;
import java.awt.*;

public class JewelCreator extends JPanel {
    /**
     * This class is responsible for making a random 'jewel' and painting it onto a JPanel
     */

    public JewelCreator() {
        super.setSize(100, 100);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Jewels.Shapes shape = Jewels.Shapes.randomShape();
        if (shape == Jewels.Shapes.Circle) {
            super.paintComponent(g);
            setSize(50, 50);
            setBounds(2, 2, 50, 50);

            Circle circle = new Circle();
            setForeground(circle.get_jewel_color());
            g.fillOval(Jewels.JEWEL_X, Jewels.JEWEL_Y, Jewels.JEWEL_HEIGHT, Jewels.JEWEL_WIDTH);
        }
        if (shape == Jewels.Shapes.Square) {
            super.paintComponent(g);
            setSize(50, 50);
            setBounds(2, 2, 50, 50);
            Square square = new Square();
            setForeground(square.get_jewel_color());
            g.fillRect(Jewels.JEWEL_X, Jewels.JEWEL_Y, Jewels.JEWEL_HEIGHT, Jewels.JEWEL_WIDTH);
        }
        if (shape == Jewels.Shapes.Triangle) {
            super.paintComponent(g);
            setSize(50, 50);
            setBounds(2, 2, 50, 50);
            Triangle triangle = new Triangle();
            setForeground(triangle.get_jewel_color());
            g.fillPolygon(triangle.X, triangle.Y, triangle.n);
        }
    }
}
