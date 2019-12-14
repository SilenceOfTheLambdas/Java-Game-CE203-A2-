package logic;

import display.Game;
import display.MainMenu;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameOver extends JFrame {

    JTextArea top5scores = new JTextArea();
    PlayerScores ps = new PlayerScores();
    Game currentGame;
    public void updateScore() throws IOException {
        if (!(Game.userName == null)) {
            ps.writeFile();
        }
    }

    public GameOver(Game game) throws IOException {
        this.currentGame = game;
        currentGame.dispose();
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

//        Button actions
        exitGame.addActionListener(actionEvent -> {
//                This will exit the game once the exit button is pressed
            System.exit(1);
        });
        replay.addActionListener(actionEvent -> {
            new MainMenu();
            dispose();
        });

        ps.readFile(top5scores);
        setSize(350, 400);
        add(scorePanel, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
