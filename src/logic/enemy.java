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

    public enemy(JPanel[][] game_area) {
        this.grid_array = game_area;
    }
    @Override
    public void run() {
        System.out.println("Spawning enemy now.....");
        int spawn_location = (int)(Math.random() * grid_array.length);
//        TODO: Enemy shape should be spawned here
        System.out.println("Enemy spawned ");
    }
}
