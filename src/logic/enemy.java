package logic;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

/**
 * This is used to spawn enemies in each round, after the 'buy' section.
 * The enemy will be a red square that will randomly move from the top of the board,
 * to the bottom.
 */

public class enemy extends TimerTask {
    private JPanel[][] grid_array; // The grid that the enemies will spawn on
    int movement_speed = 2; // how quickly the enemies will move from one grid cell to another

    public enemy(JPanel[][] grid_array) {
        this.grid_array = grid_array;
    }

    @Override
    public void run() {
        System.out.println("Spawning enemy now.....");
        int spawn_location = (int)(Math.random() * grid_array.length);
        try {
            if (!(grid_array[0][spawn_location].getBackground() == Color.red)) {
                grid_array[0][spawn_location].setBackground(Color.red);
            }
        } finally {
            System.out.println("error");
        }
        System.out.println("Enemy spawned ");
    }
}
