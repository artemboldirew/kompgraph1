package boldyrev.model.shape;

import boldyrev.model.interfaces.IShape;
import boldyrev.model.interfaces.RepaintObserver;

import java.awt.*;

public class Moon extends MovableShape implements IShape {
     public Moon(int x, int y, int width, RepaintObserver observer) {
        super(x, y, width, observer);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, width, width);
    }
}
