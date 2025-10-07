package boldyrev.model.shape;

import boldyrev.model.interfaces.IShape;
import boldyrev.model.interfaces.RepaintObserver;
import boldyrev.model.structure.MovableShape;

import java.awt.*;

public class Sun extends MovableShape implements IShape {

    public Sun(int x, int y, int width) {
        super(x, y, width);
    }

    @Override
    public void draw(Graphics2D gr) {
        gr.setColor(Color.WHITE);
        gr.fillOval(x, y, width, width);
    }
}
