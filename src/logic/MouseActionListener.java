package logic;

import objects.JewelCreator;
import objects.Jewels;

import javax.swing.*;

import display.Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseActionListener extends MouseAdapter {

    JPanel[][] game_grid;
    boolean selected = true;
    boolean isAlive, isPattern, switchedBack;
//    TODO: Find a way to link game_grid to a type of jewel
    int fromX, fromY, toX, toY;

    public MouseActionListener(JPanel[][] game) {
        this.game_grid = game;
        isPattern = switchedBack = false;
        isAlive = true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int x = 0; x < Game.jewels_coords.length; x++) {
            for (int y = 0; y < Game.jewels_coords[x].length; y++) {
                System.out.println(Game.jewels_coords[x][y]);
            }
        }
        
    }
}

//     private void selectJewels(MouseEvent e) {
//         int x = e.getX();
//         int y = e.getY();

//         if (!selected) {
//             fromX = x;
//             fromY = y;
//             selected = true;
//         } else { // Select the 2nd jewel and switch them
//             toX = x;
//             toY = y;
//             if((Math.abs(fromX - toX) == 1 ^ Math.abs(fromY - toY) == 1) & (jewels[fromX][fromY].getType() != jewels[toX][toY].getType())) {
//                 switchGems();
//                 selected = false;
//             }
//         }
//     }

//     private void switchGems() { // Switch the two jewels the user selected
//         Jewels.Shapes tmpJewelType = jewels[fromX][fromY].getType();
//         jewels[fromX][fromY].setType(jewels[toX][toY].getType());
//         jewels[toX][toY].setType(tmpJewelType);
//         checkPattern(); // Check to see if a pattern has been made, if not revert back
//     }

//     private void checkPattern() {
//         Jewels tmp1 = new Jewels() {
//             Color col;
//             Shapes type;
//             @Override
//             public Color get_jewel_color() {
//                 return col;
//             }

//             @Override
//             public void setJewelColor() {

//             }

//             @Override
//             public Shapes getType() {
//                 return type;
//             }

//             @Override
//             public void setType(Shapes jewelToChangeInto) {
//                 this.type = jewelToChangeInto;
//             }
//         };
//         Jewels tmp2 = new Jewels() {
//             Color col;
//             Shapes type;
//             @Override
//             public Color get_jewel_color() {
//                 return col;
//             }

//             @Override
//             public void setJewelColor() {

//             }

//             @Override
//             public Shapes getType() {
//                 return type;
//             }

//             @Override
//             public void setType(Shapes jewelToChangeInto) {
//                 this.type = jewelToChangeInto;
//             }
//         };

//         isPattern = false;
//         for (int i = 0; i < 8; i++) {
//             for (int x = 0; x < 8; i++) {
//                 try {
//                     if ((jewels[i][x].getType() == jewels[i+1][x+1].getType()) && (jewels[i+1][x].getType() == jewels[i+2][x].getType())) {
//                         try {
//                             if (jewels[i+2][x].getType() == jewels[i+3][x].getType()) { // Is there 4 horizontal jewels in a row?
//                                 tmp1 = jewels[i+3][x]; // set tmp1 to the 4th gem in the row
//                                 try {
//                                     if (jewels[i+3][x].getType() == jewels[i+4][x].getType()) {
//                                         tmp2 = jewels[i+4][x]; // Set this to the 5th element
//                                     }
//                                 } catch (Exception e) { e.printStackTrace(); }
//                             }
//                         } catch (Exception e) { e.printStackTrace(); }
//                         isPattern = true;
//                         removePattern(jewels[i][x], jewels[i][x+1], jewels[i][x+2], tmp1, tmp2);
//                     }
//                 } catch (Exception e) {
//                     System.out.println(e);
//                 }
//             }
//         }
//     }

//     private void removePattern(Jewels jewels, Jewels jewels1, Jewels jewels2, Jewels tmp1, Jewels tmp2) {
//         jewels.setType(Jewels.Shapes.Deleted);
//         jewels1.setType(Jewels.Shapes.Deleted);
//         jewels2.setType(Jewels.Shapes.Deleted);
//         tmp1.setType(Jewels.Shapes.Deleted);
//         tmp2.setType(Jewels.Shapes.Deleted);

//         for (int x = 0; x < 8; x++) {
//             for (int y = 0; y < 8; y++) {
//                 if (this.jewels[x][y].getType() == Jewels.Shapes.Deleted) {
//                     for (int i = y; i >= 0; i--) {
//                         if (i == 0)
//                             this.jewels[x][i].setType(this.jewels[x][i].genType());
//                         else
//                             this.jewels[x][i].setType(this.jewels[x][i - 1].getType());
//                     }
//                 }
//             }
//         }
//         checkPattern();
//     }
// }
