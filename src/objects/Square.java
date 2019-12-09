package objects;

import java.awt.*;

import display.Game;

public class Square extends Jewels {

    /**
     *
     */
    private static final long serialVersionUID = 3720511731188124409L;
    private Shapes type = Shapes.Square;

    Square() {
        setJewelColor();
        addToArray();
    }

    @Override
    public Color get_jewel_color() {
        return super.jewelColor;
    }

    @Override
    public void setJewelColor() {
        super.jewelColor = Color.BLUE;
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
