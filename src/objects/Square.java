package objects;

import java.awt.*;

public class Square extends Jewels {

    Square() {
        setJewelColor();
    }

    @Override
    public Color get_jewel_color() {
        return super.jewelColor;
    }

    @Override
    public void setJewelColor() {
        super.jewelColor = Color.BLUE;
    }
}
