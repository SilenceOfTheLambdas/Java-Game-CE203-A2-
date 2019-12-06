package logic;

import display.Game;

import javax.swing.*;
import java.awt.*;

public class LevelHandler {

    private JPanel[][] game_grid;

    public LevelHandler(JPanel[][] game_grid) {
        this.game_grid = game_grid;
    }

    private void gameOver() {
        System.out.println("Game Over!");
        System.exit(0);
//        TODO: Display a game over screen showing final score
    }

//    TODO: Create a system that will make a new jewel in a random location and place it on the game_grid

}
