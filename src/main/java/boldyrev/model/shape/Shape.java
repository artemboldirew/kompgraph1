package boldyrev.model.shape;

import java.awt.*;

public class Shape {
    protected int x;
    protected int y;
    protected int width;

    protected int getVal(double cnt) {
        return (int)(width * cnt);
    }

    public Shape(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

}
