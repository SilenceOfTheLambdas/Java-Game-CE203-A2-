package display;

import logic.KeyboardListener;
import logic.MouseClickListener;
import logic.enemy;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.Color;

public class Game extends JFrame {
    /**
     * This class is used to 'display' the game.
     */
    private static final int ROUND_TIME = 60000; // Time for each round (1 minute)

    private JPanel grid_panel; // panel used to display grid panels
    private JPanel[][] grid_array = new JPanel[50][50]; // array used to store panels in grid

    public void initialise() {
        // if grid already drawn (reinitialise rather than initialise) remove grid from frame and delete it
        if (grid_panel != null) {
            this.remove(grid_panel);
            grid_panel = null;
        }
//        panel used to display the scores
        JPanel score_panel = new JPanel(new BorderLayout());
//        The panel used to hold the game grid
        JPanel game_panel = new JPanel(new BorderLayout());
        grid_panel = new JPanel(new GridLayout(50, 50));

//        Set properties for components
        score_panel.setBackground(Color.WHITE);
        JTextArea score_area = new JTextArea();
        score_area.setText("Score: 122");
        score_area.setEditable(false);

        // Display a grid, highlighting the path for enemies
        for (int x = 0; x < grid_array.length; x++) {
            for (int y = 0; y < grid_array[x].length; y++) {
                grid_array[x][y] = new JPanel();
                grid_array[x][y].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, false));
                // unique mouse listener per panel to determine which panel was clicked
                grid_array[x][y].addMouseListener(new MouseClickListener(this));
                grid_panel.add(grid_array[x][y]);
            }
        }
        drawPath(grid_array);
        game_panel.add(grid_panel);
        score_panel.add(score_area);
        // add panel to frame
        this.add(score_panel, BorderLayout.NORTH);
        this.add(game_panel, BorderLayout.CENTER);
    }

    Game() throws Exception {
        // set up game environment
        initialise();
        // key listener to respond to key events
        addKeyListener(new KeyboardListener(this));

        // standard configuration
        setSize(new Dimension(900, 900));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);

//        Spawn in the enemies
        TimerTask enemySpawner = new enemy(grid_array);
        Timer timer = new Timer(true);
        // Spawn time for enemies
        int spawn_interval = 3000;
        timer.scheduleAtFixedRate(enemySpawner, 0, spawn_interval);

        Thread.sleep(ROUND_TIME); // Do this for 1 minute
    }

    public void drawPath(JPanel[][] game_grid) {
//        This will make certain areas of the grid have no border, giving the illusion of a path

//        This contains some x and y coordinates made from an image, it will display a 'path'
        int[][] coords = {{18,0}, {25,0}, {18,1}, {25,1}, {18,2}, {25,2}, {18,3}, {25,3}, {18,4}, {25,4}, {18,5}, {25,5}, {18,6}, {25,6},
                    {18,7}, {25,7}, {18,8}, {25,8}, {18,9}, {25,9}, {18,10}, {26,10}, {27,10}, {28,10}, {29,10}, {16,11}, {17,11}, {30,11},
                    {14,12}, {15,12}, {31,12}, {13,13}, {32,13}, {33,13}, {11,14}, {12,14}, {34,14}, {35,14}, {36,14}, {11,15}, {37,15}, {10,16},
                    {38,16}, {39,16}, {9,17}, {10,17}, {26,17}, {27,17}, {28,17}, {40,17}, {9,18}, {25,18}, {29,18}, {30,18}, {31,18}, {41,18},
                    {10,19}, {24,19}, {32,19}, {33,19}, {42,19}, {43,19}, {44,19}, {45,19}, {11,20}, {12,20}, {23,20}, {34,20}, {35,20}, {36,20}, {45,20}, {11,21},
                    {23,21}, {37,21}, {46,21}, {12,22}, {13,22}, {23,22}, {38,22}, {46,22}, {13,23}, {14,23}, {24,23}, {39,23}, {47,23}, {14,24}, {24,24}, {39,24},
                    {47,24}, {14,25}, {25,25}, {40,25}, {48,25}, {14,26}, {25,26}, {41,26}, {49,26}, {15,27}, {26,27}, {41,27}, {15,28}, {27,28}, {41,28}, {14,29},
                    {28,29}, {42,29}, {14,30}, {29,30}, {30,30}, {43,30}, {14,31}, {31,31}, {44,31}, {13,32}, {32,32}, {45,32}, {46,32}, {13,33},
                    {33,33}, {34,33}, {47,33}, {12,34}, {22,34}, {23,34}, {24,34}, {35,34}, {36,34}, {48,34}, {49,34}, {11,35}, {22,35}, {25,35}, {26,35},
                    {37,35}, {38,35}, {11,36}, {21,36}, {26,36}, {39,36}, {10,37}, {11,37}, {21,37}, {27,37}, {40,37}, {10,38}, {20,38}, {28,38}, {41,38},
                    {10,39}, {20,39}, {29,39}, {30,39}, {42,39}, {9,40}, {19,40}, {31,40}, {32,40}, {43,40}, {8,41}, {9,41}, {19,41}, {33,41}, {34,41},
                    {44,41}, {8,42}, {19,42}, {35,42}, {36,42}, {45,42}, {8,43}, {19,43}, {37,43}, {46,43}, {7,44}, {18,44}, {19,44}, {38,44}, {47,44},
                    {6,45}, {18,45}, {38,45}, {48,45}, {6,46}, {17,46}, {38,46}, {49,46}, {5,47}, {16,47}, {39,47}, {4,48}, {15,48}, {39,48}, {4,49}, {14,49}, {39,49}};

        for (int i = 0; i < game_grid.length; i++) {
            for (int x = 0, y = 1; x < coords.length; x++) {
                int xCoord = coords[x][0];
                int yCoord = coords[x][1];
                game_grid[xCoord][yCoord].setBorder(null);
                game_grid[xCoord][yCoord].setBackground(Color.BLACK);
            }
        }
    }
}
