package logic;
import display.Game;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

/**
 * This is used to spawn enemies in each round, after the 'buy' section.
 * The enemy will be a red square that will randomly move from the top of the board,
 * to the bottom.
 */

public class enemy extends TimerTask {
    JPanel[][] grid_array;
    int spawn_interval = 1000; // spawn an enemy every second
    int movement_speed = 2;

    public enemy(JPanel[][] grid_array) {
        this.grid_array = grid_array;
    }

    @Override
    public void run() {
        System.out.println("Spawning enemy now.....");
        int spawn_location = (int)(Math.random() * 50 - 1);
        try {
            if (!(grid_array[0][spawn_location].getBackground() == Color.red)) {
                grid_array[0][spawn_location].setBackground(Color.red);
            }
            Thread.sleep(spawn_interval);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("Enemy spawned ");
    }
}
