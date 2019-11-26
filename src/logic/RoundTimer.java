package logic;

import display.Game;

import javax.swing.*;
import java.util.TimerTask;

public class RoundTimer extends TimerTask {
    private JPanel[][] grid_array;
    private Game game;
    private int levelNo = 1; // The level number, this is incremented every round

    public RoundTimer(JPanel[][] grid_array, Game game) {
        this.grid_array = grid_array;
        this.game = game;
    }

    @Override
    public void run() {
        try {
            game.initialise(); // Refresh the display
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            levelNo++;
            Levels nextLevel = new Levels(levelNo, grid_array); // Make a new levels object
            nextLevel.loadNextLevel(); // Then load the next level
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
