package ru.vsu.cs.boldyrev.model.structure;

import ru.vsu.cs.boldyrev.model.interfaces.IMovableShape;

import java.awt.*;

public abstract class MovableShape extends Shape implements IMovableShape{
    public MovableShape(int x, int y, int width) {
        super(x, y, width);
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
