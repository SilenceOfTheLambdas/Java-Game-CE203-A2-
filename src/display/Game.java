package display;

import logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.Color;

public class Game extends JFrame {

    private JPanel grid_panel; // panel used to display grid panels
    private JPanel[][] grid_array = new JPanel[8][8]; // array used to store panels in grid

    private JMenuBar game_menu = new JMenuBar();
    private JMenuItem game_options = new JMenuItem("Game");

    public void init() {
        // if grid already drawn (reinitialise rather than initialise) remove grid from frame and delete it
        if (grid_panel != null) {
            this.remove(grid_panel);
            grid_panel = null;
        }
//        The panel used to hold the game grid
        JPanel game_panel = new JPanel(new BorderLayout());
        grid_panel = new JPanel(new GridLayout(8, 8));

        // for loop to create grid
        for (int x = 0; x < grid_array.length; x++) {
            for (int y = 0; y < grid_array[x].length; y++) {
                grid_array[x][y] = new JPanel();
                grid_array[x][y].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
                // unique mouse listener per panel to determine which panel was clicked
                grid_array[x][y].addMouseListener(new MouseClickListener(this));
                grid_panel.add(grid_array[x][y]);
            }
        }
        game_panel.add(grid_panel);
        game_menu.add(game_options);
        // add panel to frame
        this.add(game_menu, BorderLayout.NORTH);
        this.add(game_panel, BorderLayout.CENTER);
    }

    Game() {
//        Setup game environment
        init();
        setSize(900, 900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
    }
}
