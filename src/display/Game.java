package display;

import logic.Board;
import logic.GameOver;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends JFrame {

    public JLabel score = new JLabel();
    public static int SCORE = 0;
    public static String userName;
    JLabel countdown = new JLabel();
    int count = 120; // Countdown timer (in seconds)
    Timer timer = new Timer();

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
        score_pane.add(score);
        score_pane.setBackground(Color.WHITE);
        score_pane.setForeground(Color.BLACK);
        getContentPane().add(score_pane, BorderLayout.SOUTH);
        score_pane.add(countdown);
    }

    public void updateScore() {
        SCORE++;
        score.setText("Current Score: " + SCORE + " | " + userName);
        score.repaint();
    }

    public void countDown() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                countdown.setText("Countdown: " + count);
                count--;
                if (count == -1) {
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public Game() {
        setMenu();
        setScorePane();
        countDown();
        Board game = new Board(this);
        getContentPane().add(game, BorderLayout.CENTER);
        game.start();

        setTitle("Rainbow $hit | 1806094");
        setSize(350, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                this.cancel();
                game.setVisible(false);
                GameOver gameOver = null;
                try {
                    gameOver = new GameOver();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert gameOver != null;
                gameOver.setLocationRelativeTo(null);
                gameOver.setVisible(true);
            }
        }, 120*100); // Do this ^ after 2 minutes
    }
}
