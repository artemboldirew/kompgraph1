package boldyrev.model.structure;

import boldyrev.model.interfaces.IMovableShape;
import boldyrev.model.interfaces.RepaintObserver;

import java.awt.*;

public abstract class MovableShape extends Shape implements IMovableShape{
    protected RepaintObserver observer;
    public MovableShape(int x, int y, int width, RepaintObserver observer) {
        super(x, y, width);
        this.observer = observer;
    }

    public void transform(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        //observer.requestRepaint();
    }

    public void moveTo(int cx, int cy) {
        this.x = cx;
        this.y = cy;
    }

    public abstract void draw(Graphics2D g);
}
