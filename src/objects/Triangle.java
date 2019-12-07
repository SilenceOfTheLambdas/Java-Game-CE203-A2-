package objects;

import java.awt.*;

public class Triangle extends Jewels {

    public final int[] X = {35, 22, 10};
    public final int[] Y = {35, 10, 35};
    public int n = 3;

    Triangle() {
        setJewelColor();
    }

    @Override
    public Color get_jewel_color() {
        return super.jewelColor;
    }

    @Override
    public void setJewelColor() {
        super.jewelColor = Color.CYAN;
    }
}
