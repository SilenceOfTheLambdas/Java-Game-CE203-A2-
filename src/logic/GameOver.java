package logic;

import display.Game;
import display.MainMenu;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class GameOver extends JFrame {

    JTextArea top5scores = new JTextArea();
    PlayerScores ps = new PlayerScores();
    Map<String, Integer> playerData = new HashMap<>();
    Game currentGame;
    public void updateScore() throws IOException {
        if (!(Game.userName == null)) {
            ps.writeFile(); // Update the players final score
        }
    }

    public void obtainPlayerData() throws FileNotFoundException {
//        This method will obtain the top 5 players and add them to the playerData array
        Scanner scanner = new Scanner(new FileReader("scores.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] temp = line.split(" ");
            playerData.put(temp[0], Integer.valueOf(temp[1]));
        }
        sortByValue(false);
    }

    public void sortByValue(boolean order) {
//        Convert the HashMap into a list
        List<Entry<String, Integer>> list = new LinkedList<>(playerData.entrySet());
        list.sort((stringIntegerEntry, t1) -> {
            if (order) {
                return stringIntegerEntry.getValue().compareTo(t1.getValue());
            } else {
                return t1.getValue().compareTo(stringIntegerEntry.getValue());
            }
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        printScore(sortedMap);
    }

    private void printScore(Map<String, Integer> sortedMap) {
        top5scores.append("Top 5 Scores \n");
        int i = 0;
        for (Entry<String, Integer> entry : sortedMap.entrySet()) {
            if (i < 5)
                top5scores.append(entry.getKey() + "\t" + entry.getValue() + "\n");
                i++;
        }
    }

    public GameOver(Game game) throws IOException {
        this.currentGame = game;
        currentGame.dispose();
        JPanel scorePanel = new JPanel();
        JPanel leaderBoard = new JPanel();
        JPanel buttons = new JPanel();

        JLabel totalScore = new JLabel();
        top5scores.setEditable(false);
        JButton exitGame = new JButton("Exit");
        JButton replay = new JButton("Play again");

        totalScore.setText("Final Score: " + Game.SCORE + "\n");
        scorePanel.add(totalScore);
        leaderBoard.add(top5scores);
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

        obtainPlayerData(); // Gets the top 5 players and displays it
        setSize(350, 400);
        add(scorePanel, BorderLayout.NORTH);
        add(leaderBoard, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
