package objects;

import java.awt.*;

public class Circle extends Jewels {

    Circle() {
        setJewelColor();
    }

    @Override
    public Color get_jewel_color() {
        return super.jewelColor;
    }

    @Override
    public void setJewelColor() {
        super.jewelColor = Color.RED;
    }

}
