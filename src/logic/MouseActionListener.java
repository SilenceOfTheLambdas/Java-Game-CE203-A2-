package logic;

import display.Game;
import objects.Jewels;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static logic.Board.*;

public class MouseActionListener extends MouseAdapter {

    private static Board board;
    private static Game game;

    public MouseActionListener(Board board, Game game) {
        MouseActionListener.board = board;
        MouseActionListener.game = game;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        selectJewels(e);
    }

    public void selectJewels(MouseEvent e) {
        int x = e.getX() / board.cellWidth();
        int y = e.getY() / board.cellHeight();

        if (!board.selected) {
            board.fromX = x;
            board.fromY = y;
            board.selected = true;
        } else {
            board.toX = x;
            board.toY = y;
            if((Math.abs(board.fromX - board.toX) == 1 ^ Math.abs(board.fromY - board.toY) == 1) & (jewels[board.fromX][board.fromY].getType() != jewels[board.toX][board.toY].getType())) {
                switchJewels();
                board.selected = false;
            }
        }
    }

    public static void switchJewels() {
        int tempType = jewels[board.fromX][board.fromY].getType();
        jewels[board.fromX][board.fromY].setType(jewels[board.toX][board.toY].getType());
        jewels[board.toX][board.toY].setType(tempType);
        checkPattern(); // Check to see if a pattern has been created after jewels have been switched

        switchedBack = false;
        board.repaint();
    }

    public static void checkPattern() {
        Jewels temp1 = new Jewels(); // These will hold deleted jewels
        Jewels temp2 = new Jewels();

        isPattern = false;
        for (int x = 0; x < BOARDWIDTH; x++) {
            for (int y = 0; y < BOARDHEIGHT; y++) {
                if (x + 2 < BOARDWIDTH && jewels[x][y].getType() == jewels[x + 1][y].getType() && (jewels[x + 1][y].getType() == jewels[x + 2][y].getType())) { //Checks for 3 horizontal jewels in a row
                    game.updateScore();
                    if (x + 3 < BOARDWIDTH && jewels[x + 2][y].getType() == jewels[x + 3][y].getType()) { //checks for 4 horizontal jewels in a row
                        game.updateScore();
                        temp1 = jewels[x + 3][y]; //set dummy1 to the fourth gem in the row
                    }
            isPattern = true;
            deletePattern(jewels[x][y], jewels[x + 1][y], jewels[x + 2][y], temp1, temp2); //delete the jewels that are in a pattern
        }
            if (y + 2 < BOARDHEIGHT && (jewels[x][y].getType() == jewels[x][y + 1].getType()) && (jewels[x][y + 1].getType() == jewels[x][y + 2].getType())) { //Check for 3 vertical jewels in a row
                game.updateScore();
                if (y + 3 < BOARDHEIGHT && jewels[x][y + 2].getType() == jewels[x][y + 3].getType()) { //checks for 4 vertical jewels in a row
                    game.updateScore();
                    temp1 = jewels[x][y + 3]; //set dummy1 to the fourth gem in the row
                }
                isPattern = true;
                deletePattern(jewels[x][y], jewels[x][y + 1], jewels[x][y + 2], temp1, temp2);
            }
        }
    }

        if (!isPattern && !switchedBack) {
            switchedBack = true;
            switchJewels();
        }
    }

    public static void deletePattern(Jewels jewels1, Jewels jewels2, Jewels jewels3, Jewels jewels4, Jewels jewels5) {
//        Set each of the jewels to be deleted, to the deleted type
        jewels1.setType(8);
        jewels2.setType(8);
        jewels3.setType(8);
        jewels4.setType(8);
        jewels5.setType(8);

        for (int x = 0; x < BOARDWIDTH; x++) {
            for (int y = 0; y < BOARDHEIGHT; y++) {
                if (jewels[x][y].getType() == 8) {
//                    IF the type of jewel is of type 'deleted'
                    for (int i = y; i >= 0; i--) {
                        if (i == 0) // if a jewel is deleted from the top row, delete it
                            jewels[x][i].setType(jewels[x][i].genType());
                        else
                            jewels[x][i].setType(jewels[x][i-1].getType());
                    }
                }
            }
        }
        checkPattern(); // Check for any new patterns that have appeared on the board, it will keep doing this until there are no more patterns
    }
}
