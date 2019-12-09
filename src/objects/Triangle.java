package objects;

import java.awt.*;

import display.Game;

public class Triangle extends Jewels {

    /**
     *
     */
    private static final long serialVersionUID = -8591888787328696020L;
    public final int[] X = { 35, 22, 10 };
    public final int[] Y = { 35, 10, 35 };
    public int n = 3;
    private Shapes type = Shapes.Triangle;

    Triangle() {
        setJewelColor();
        addToArray();
    }

    @Override
    public Color get_jewel_color() {
        return super.jewelColor;
    }

    @Override
    public void setJewelColor() {
        super.jewelColor = Color.CYAN;
    }

    @Override
    public Shapes getType() {
        return type;
    }

    @Override
    public void setType(Shapes jewelToChangeInto) {
        this.type = jewelToChangeInto;
    }

    @Override
    public void addToArray() {
        // Add this object to the global array
        for (int x = 0; x < Game.jewels_coords.length; x++) {
            for (int y = 0; y < Game.jewels_coords[x].length; y++) {
                Game.jewels_coords[x][y] = getType();
            }
        }
    }
}
