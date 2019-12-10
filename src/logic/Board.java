package logic;

import objects.Jewels;
import objects.Square;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    public final static int BOARDWIDTH = 8;
    public final static int BOARDHEIGHT = 8;
    public final int CELLWIDTH = (int) getSize().getWidth() / BOARDWIDTH;
    public final int CELLHEIGHT = (int) getSize().getHeight() / BOARDHEIGHT;

    public static boolean isAlive, isPattern,switchedBack;
    public static Jewels[][] jewels;
    int fromX, fromY, toX, toY;
    boolean selected = true;
//    Colours !!!!
    private static final Color[] COLOURS = { new Color(255, 0, 0),
            new Color(255, 128, 0), new Color(255, 255, 0),
            new Color(0, 255, 0), new Color(0, 255, 255),
            new Color(0, 0, 255), new Color(127, 0, 255),
            new Color(0, 0, 0) };

    public Board() {
        jewels = new Jewels[BOARDWIDTH][BOARDHEIGHT];
        addMouseListener(new MouseActionListener(this));
    }

    public int cellWidth() {
        return (int) getSize().getWidth() / BOARDWIDTH;
    }

    public int cellHeight() {
        return (int) getSize().getHeight() / BOARDHEIGHT;
    }

    public void start() {
        isPattern = switchedBack = false; // Reset these booleans
        isAlive = true; // set the game to a running state
        do { // do this once, and then only when a pattern has been found
            fillBoard();
            MouseActionListener.checkPattern();
        } while (isPattern);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int x = 0; x < BOARDWIDTH; x++) {
            for (int y = 0; y < BOARDHEIGHT; y++) {
                drawCell(g, x, y, jewels[x][y]); // Paint each cell
            }
        }
    }

    public void fillBoard() {
        for (int x = 0; x < BOARDWIDTH; x++) {
            for (int y = 0; y < BOARDHEIGHT; y++) {
                jewels[x][y] = new Jewels();
            }
        }
    }

    public void drawCell(Graphics g, int x, int y, Jewels jewel) {
        x = x * cellWidth();
        y = y * cellHeight();
        Color colour = COLOURS[(jewel.getType())];

        g.setColor(colour);
        new Square(g, x, y, x + cellWidth(), y + cellHeight());
//        if (jewel.getType() == 0 || jewel.getType() == 3) {
//            new Sqaure(g, x, y, x + cellWidth(), y + cellHeight());
//        }if (jewel.getType() == 1 || jewel.getType() == 4 || jewel.getType() == 6) {
//            new Circle(g, x + 2, y + 2, cellWidth() - 4, cellHeight() - 4);
//        }if (jewel.getType() == 2 || jewel.getType() == 5 || jewel.getType() == 7) {
//            new Triangle(g, 0, 0, cellWidth() - 4, cellHeight() - 4);
//        }

        g.setColor(Color.BLACK); // Border each of the cells (makes it look a little better imo
        g.drawLine(x, y, x, y + cellHeight());
        g.drawLine(x, y + cellHeight(), x + cellWidth(), y + cellHeight());
        g.drawLine(x + cellWidth(), y + cellHeight(), x + cellWidth(), y);
        g.drawLine(x + cellWidth(), y, x, y);
    }


}
