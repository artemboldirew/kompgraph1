package boldyrev.model.shape;

import boldyrev.DrawPanel;
import boldyrev.model.interfaces.RepaintObserver;

public class MovableShape extends Shape{
    protected RepaintObserver observer;
    MovableShape(int x, int y, int width, RepaintObserver observer) {
        super(x, y, width);
        this.observer = observer;
    }

    protected void transform(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        observer.requestRepaint();
    }
}
