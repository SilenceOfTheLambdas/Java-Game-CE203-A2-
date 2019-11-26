package logic;

import display.Game;

import javax.swing.*;
import java.util.TimerTask;

public class RoundTimer extends TimerTask {
    JPanel[][] grid_array;
    Game game;
    Levels levels;
    public RoundTimer(JPanel[][] grid_array, Game game, Levels level) {
        this.grid_array = grid_array;
        this.game = game;
        this.levels = level;
    }

    private int levelNo = 2;
    @Override
    public void run() {
        try {
            game.initialise();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        levelNo++;
        try {
            levels.loadNextLevel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
