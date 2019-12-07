package objects;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class JewelCreator extends JPanel {

    Graphics g;

    public enum Shapes {
        Circle,
        Square
    }

    private Shapes[] shapes = Shapes.values();
    private Random random = new Random();
    Shapes getRandShape;

    public JewelCreator() {
        setForeground(Color.RED);
        super.setSize(100, 100);
    }

    public Graphics getG() {
        return g;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setSize(50, 50);
        setBounds(2, 2, 50, 50);
        g.fillOval(10, 10, 25, 25);
    }
}
