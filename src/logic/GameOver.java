package logic;

import display.Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

public class GameOver extends JFrame{

    public void updateScore() throws IOException {
        PlayerScores ps = new PlayerScores();
        ps.writeFile();
        ps.readFile();
        ps.updatePlayers();
    }

    public GameOver() throws IOException {

        updateScore();
        JPanel scorePanel = new JPanel();
        JPanel buttons = new JPanel();

        JLabel totalScore = new JLabel();
        JButton exitGame = new JButton("Exit");
        JButton replay = new JButton("Play again");

        totalScore.setText("Final Score: " + Game.SCORE);
        scorePanel.add(totalScore);
        buttons.add(exitGame);
        buttons.add(replay);

        setSize(350, 400);
        add(scorePanel, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
