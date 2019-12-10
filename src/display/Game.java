package display;

import logic.Board;
import javax.swing.*;

public class Game extends JFrame {

    public Game() {
        Board game = new Board();
        getContentPane().add(game);
        game.start();

        setTitle("Totally NOT bejeweled *Kappa*");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
