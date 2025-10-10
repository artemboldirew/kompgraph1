package ru.vsu.cs.boldyrev.model.shape;

import ru.vsu.cs.boldyrev.model.interfaces.IShape;
import ru.vsu.cs.boldyrev.model.structure.Shape;

import java.awt.*;

public class Hills extends Shape implements IShape {

    public Hills(int x, int y, int width) {
        super(x, y, width);
    }

    @Override
    public void draw(Graphics2D gr) {
        Color snow = new Color(198, 219, 214);
        gr.setColor(snow);
        gr.fillOval(-380, 663, 1065, 1065);
        gr.fillOval(-63, 665, 1065, 1065);
    }
}
