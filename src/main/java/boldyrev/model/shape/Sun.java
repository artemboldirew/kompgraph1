package boldyrev.model.shape;

import boldyrev.DrawPanel;
import boldyrev.model.interfaces.IShape;
import boldyrev.model.interfaces.RepaintObserver;

import java.awt.*;

public class Sun extends MovableShape implements IShape {

    public Sun(int x, int y, int width, RepaintObserver observer) {
        super(x, y, width, observer);
    }

    @Override
    public void draw(Graphics2D gr) {
        gr.setColor(Color.WHITE);
        gr.fillOval(x, y, width, width);
    }
}
