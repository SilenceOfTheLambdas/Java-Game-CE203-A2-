package display;

import logic.Board;
import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public static JLabel score = new JLabel();
    public static int SCORE = 0;
    public void setMenu() {
//        Creates a new menubar
        JMenuBar game_menubar = new JMenuBar();
        JMenuItem new_game = new JMenuItem("New game");
        JMenuItem pause = new JMenuItem("Pause");
        JMenuItem quit_game = new JMenuItem("Quit game");
        JMenu game_menu = new JMenu("Game");
        game_menu.add(new_game); game_menu.add(pause); game_menu.add(quit_game);
        game_menubar.add(game_menu);
        game_menubar.setBackground(Color.WHITE);
        game_menubar.setForeground(Color.BLACK);
        this.setJMenuBar(game_menubar);
    }


    public void setScorePane() {
        JPanel score_pane = new JPanel();
        updateScore();
        score_pane.add(score);
//        TODO: Increase score every time a 'match' is made
        score_pane.setBackground(Color.WHITE);
        score_pane.setForeground(Color.BLACK);
        getContentPane().add(score_pane, BorderLayout.SOUTH);
    }

    public static void updateScore() {
        SCORE++;
        score.setText("Current Score: " + SCORE);
        score.repaint();
    }

    public Game() {
        setMenu();
        setScorePane();
        Board game = new Board();
        getContentPane().add(game, BorderLayout.CENTER);
        game.start();

        setTitle("Rainbow $hit 1806094");
        setSize(410, 410);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
