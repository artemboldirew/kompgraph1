package boldyrev.model.shape;

import boldyrev.model.Primitives;
import boldyrev.model.interfaces.IShape;
import boldyrev.model.interfaces.RepaintObserver;

import java.awt.*;

public class Mountain extends Shape implements IShape {

    private int height;
    private Color c;

    public Mountain(int x, int y, int width, int height, Color c) {
        super(x, y, width);
        this.height = height;
        this.c = c;
    }

    @Override
    public void draw(Graphics2D gr) {
        Primitives.drawTriangle(gr, x, y, width, height, c);
        Primitives.drawTriangle(gr, (int) (x + Math.round(width*(42.5/100))), y, (int)(width*0.15), (int)(height*0.15), Color.WHITE);
    }
}
