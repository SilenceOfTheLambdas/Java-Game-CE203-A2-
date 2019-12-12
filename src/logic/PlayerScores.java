package logic;

import display.Game;

import java.io.*;
import java.util.*;

public class PlayerScores {
//    TODO: Create a players score file
//    - Write to it & then, either add a new player and their score, or update an existing players score if it's higher than there last
    String player_name = Game.userName;
    int last_score = Game.SCORE;
    int highest_score = last_score;
    Map<String, Integer> top5scores = new HashMap<>();
    List<String> fileContents = new ArrayList<>();

    public int getHighest_score() {
        if (last_score > highest_score) highest_score = last_score;
        return highest_score;
    }

    public void updatePlayers() {
//        This method will update or add a players score
        String[] scores;
        String[] names;
        for (int i = 0; i < fileContents.size(); i++) {
            if (fileContents.get(i).contains(player_name)) {
                names = fileContents.get(i).split("\\s");
                scores = fileContents.get(i).split("\\s");
                System.out.println(names[i] + " " + scores[i]);
            }
        }
    }

    public void readFile() throws IOException {
//        This method is used to obtain the top 5 players (in order of score)
        BufferedReader reader = new BufferedReader(new FileReader("%appdata%/RainbowShit/scores.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            fileContents.add(line);
        }
        reader.close();
    }

    public void writeFile() throws IOException {
//        Will create a file if it does not exist; otherwise, it will write to an existing file

//        Writes the players username and highest score
        String fileContent = player_name + " " + getHighest_score();
        FileWriter fileWriter = new FileWriter("%appdata%/RainbowShit/scores.txt");
        fileWriter.write(fileContent);
        fileWriter.close();
    }
}
