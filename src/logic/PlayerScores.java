package logic;

import display.Game;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class PlayerScores {
//    - Write to it & then, either add a new player and their score, or update an existing players score if it's higher than there last
    String player_name = Game.userName;
    int last_score = Game.SCORE;
    Map<String, Integer> fileContents = new HashMap<>();

    int highest_score = last_score;

    public void getHighest_score() throws IOException {

        Scanner sc1 = new Scanner(new FileReader("scores.txt"));
        while (sc1.hasNextLine()) {
            String line = sc1.nextLine();
            if (line.contains(player_name)) {
                String[] temp = line.split(" ");
                fileContents.put(temp[0], Integer.valueOf(temp[1]));
            }
        }
        highest_score = fileContents.get(player_name);
        if (last_score > highest_score) {
            updatePlayers(String.valueOf(highest_score), String.valueOf(last_score));
        }
    }

    public void updatePlayers(String oldString, String newString) {
//        This method will update or add a players score
        File fileToBeModified = new File("scores.txt");
        StringBuilder oldContent = new StringBuilder();

        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
//            Reading all of the lines in the text file into oldContent
            String line = reader.readLine();

            while (line != null) {
                oldContent.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
//            Replace oldString with newString in the oldContent
            String newContent = oldContent.toString().replaceAll(oldString, newString);
//            Rewrite the input text file with new content
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } catch (IOException e) { e.printStackTrace(); }
        finally {
            try {
                assert reader != null;
                reader.close();
                assert writer != null;
                writer.close();
//                Update array with new data once it has been updated
                Scanner scanner = new Scanner(new FileReader("scores.txt"));
                String name = scanner.next(player_name);
                int score = scanner.nextInt();
                fileContents.put(name, score);
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeFile() throws IOException {
//        Will create a file if it does not exist; otherwise, it will write to an existing file
//        Writes the players username and highest score
        Scanner scanner = new Scanner(new FileReader("scores.txt"));
        boolean found = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(player_name)) {
                found = true;
            }
        }
        if (!found) {
            List<String> lines = Collections.singletonList(player_name + " " + last_score);
            Path file = Paths.get("scores.txt");
            Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            fileContents.put(player_name, Game.SCORE);
        }
        getHighest_score();
    }
}
