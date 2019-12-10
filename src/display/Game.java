package display;

import logic.Board;
import javax.swing.*;

public class Game extends JFrame {

    public Game() {
        Board game = new Board();
        getContentPane().add(game);
        game.start();

        setTitle("Rainbow $hit 1806094");
        setSize(410, 410);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
