package display;

import logic.KeyboardListener;
import logic.MouseClickListener;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    /**
     * This class is used to 'display' the game.
     */
    private JPanel grid_panel; // panel used to display grid panels

    public void initialise() {
        // if grid already drawn (reinitialise rather than initialise) remove grid from frame and delete it
        if (grid_panel != null) {
            this.remove(grid_panel);
            grid_panel = null;
        }

        grid_panel = new JPanel(new GridLayout(20, 20));
        // array used to store panels in grid
        JPanel[][] grid_array = new JPanel[20][20];

        // for loop to create grid
        for (int x = 0; x < grid_array.length; x++) {
            for (int y = 0; y < grid_array[x].length; y++) {
                grid_array[x][y] = new JPanel();

                // checkered design black and white
                if ((x % 2 == 0 && y % 2 == 1) || (x % 2 == 1 && y % 2 == 0)) {
                    grid_array[x][y].setBackground(Color.BLACK);
                } else {
                    grid_array[x][y].setBackground(Color.WHITE);
                }

                // unique mouse listener per panel to determine which panel was clicked
                grid_array[x][y].addMouseListener(new MouseClickListener(this));
                grid_panel.add(grid_array[x][y]);
            }
        }

        // add panel to frame
        this.add(grid_panel);
    }

    Game() {
        // set up game environment
        initialise();
        // key listener to respond to key events
        addKeyListener(new KeyboardListener(this));

        // standard configuration
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
