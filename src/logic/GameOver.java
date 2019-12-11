package logic;

import display.Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameOver extends JFrame{

    public GameOver() {
        JPanel scorePanel = new JPanel();
        JPanel buttons = new JPanel();

        JLabel totalScore = new JLabel();
        JButton exitGame = new JButton("Exit");
        JButton replay = new JButton("Play again");

//        TODO: Multiply score based on the time it took to finish
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
