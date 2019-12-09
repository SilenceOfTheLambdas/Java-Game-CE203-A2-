package display;

import logic.MouseActionListener;
import objects.JewelCreator;
import objects.Jewels;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.Color;

public class Game extends JFrame {

    boolean gameOver = false;
    boolean gamePaused = false;
    public Jewels[][] jewels_coords = new Jewels[8][8];
    

    private static final long serialVersionUID = 1L;
    private JPanel grid_panel; // panel used to display grid panels
    private JPanel[][] grid_array = new JPanel[8][8]; // array used to store panels in grid

//    Menu bar stuff
    private JMenuBar game_menubar = new JMenuBar();
    JMenuItem new_game = new JMenuItem("New game");
    JMenuItem pause = new JMenuItem("Pause");
    JMenuItem quit_game = new JMenuItem("Quit game");

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
                JewelCreator jewelCreator = new JewelCreator(this);
                grid_array[x][y].add(jewelCreator);
                grid_panel.add(grid_array[x][y]);
            }
        }
        game_panel.add(grid_panel);

        for (int i = 0, x = 0; i < grid_array.length && x < grid_array[i].length; i++, x++) {
            grid_array[i][x].addMouseListener(new MouseActionListener(grid_array)); // Controls the state of the jewels when clicked on
        }

//        Menubar setup
        JMenu game_menu = new JMenu("Game");
        game_menu.add(new_game); game_menu.add(pause); game_menu.add(quit_game);

        game_menubar.add(game_menu);
        this.setJMenuBar(game_menubar);
        // add panel to frame
        this.add(game_panel, BorderLayout.CENTER);

//        The menu listener, used to do stuff when user clicks on a menu item
        menuListener();
    }

    public void menuListener() {
        quit_game.addActionListener(actionEvent -> {
//                Quits the game
            QuitGame();
        });
        new_game.addActionListener(actionEvent -> {
            // Re-create a new game
            this.dispose();
            new Game();
        });
        if (!gamePaused) {
            pause.addActionListener(actionEvent -> {
                pause.setText("Resume");
                gamePaused = true;
            });
        } else {
            pause.addActionListener(actionEvent -> {
                pause.setText("Pause");
                gamePaused = false;
            });
        }
    }

    Game() {
//        Setup game environment
        init();
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void QuitGame() {
        this.dispose();
        System.out.println("Game has ended");
        new MainMenu();
    }
}
