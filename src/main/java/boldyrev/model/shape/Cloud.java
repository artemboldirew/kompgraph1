package boldyrev.model.shape;

import boldyrev.model.interfaces.IShape;
import boldyrev.model.interfaces.RepaintObserver;
import boldyrev.model.structure.MovableShape;

import java.awt.*;

public class Cloud extends MovableShape implements IShape {


    public Cloud(int x, int y, int width, RepaintObserver observer) {
        super(x, y, width, observer);
    }

    @Override
    public void draw(Graphics2D gr) {
        gr.setColor(new Color(255,255,255));
        gr.fillOval(x, y + getVal(0.222), getVal(0.32), getVal(0.32));
        gr.fillOval(x + getVal(0.6767), y + getVal(0.222), getVal(0.32), getVal(0.32));
        gr.fillOval(x + getVal(25.0/99), y, getVal(50.0/99), getVal(50.0/99));
        gr.fillRect(x + getVal(15.0/99), y + getVal(39.5/99), getVal(66.0/99), getVal(14.0/99));
    }
}
