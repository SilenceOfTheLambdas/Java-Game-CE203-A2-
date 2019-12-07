package objects;

import java.awt.*;

public class Triangle extends Jewels {

    public final int[] X = {35, 22, 10};
    public final int[] Y = {35, 10, 35};
    public int n = 3;
    private Shapes type = Shapes.Triangle;

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

    @Override
    public Shapes getType() {
        return type;
    }

    @Override
    public void setType(Shapes jewelToChangeInto) {
        this.type = jewelToChangeInto;
    }
}
