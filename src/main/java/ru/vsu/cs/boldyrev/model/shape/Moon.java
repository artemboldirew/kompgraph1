package ru.vsu.cs.boldyrev.model.shape;

import ru.vsu.cs.boldyrev.model.interfaces.IShape;
import ru.vsu.cs.boldyrev.model.structure.MovableShape;

import java.awt.*;

public class Moon extends MovableShape implements IShape {
     public Moon(int x, int y, int width) {
        super(x, y, width);
    }

    @Override
    public void draw(Graphics2D g) {
         Color moonColor = new Color(189,208,228);
        g.setColor(moonColor);
        g.fillOval(x, y, width, width);
    }
}
