package logic;
import display.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private Game game; // game passed through to allow for game manipulation

    public KeyboardListener(Game app) {
        this.game = app;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("Up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Left");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right");
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("Spacebar");
                //                this.game.repaint();
                this.game.revalidate(); // repaints node children, rather than node
                break;
            default:
                System.out.println("Other");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

