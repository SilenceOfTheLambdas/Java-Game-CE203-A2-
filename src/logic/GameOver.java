package logic;

import display.Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

public class GameOver extends JFrame {

    JTextArea top5scores = new JTextArea();
    PlayerScores ps = new PlayerScores();
    public void updateScore() throws IOException {
        if (!(Game.userName == null)) {
            ps.writeFile();
        }
    }

    public GameOver() throws IOException {

        JPanel scorePanel = new JPanel();
        JPanel buttons = new JPanel();

        JLabel totalScore = new JLabel();
        top5scores.setEditable(false);
        JButton exitGame = new JButton("Exit");
        JButton replay = new JButton("Play again");

        totalScore.setText("Final Score: " + Game.SCORE);
        scorePanel.add(totalScore);
        scorePanel.add(top5scores, BorderLayout.SOUTH);
        updateScore();
        buttons.add(exitGame);
        buttons.add(replay);
        ps.readFile(top5scores);
        setSize(350, 400);
        add(scorePanel, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
