package objects;

public class Jewels {
    private int type;

    public Jewels() {
        this.type = genType();
    }

    public int genType() {
        return (int) (Math.random() * 7);
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}