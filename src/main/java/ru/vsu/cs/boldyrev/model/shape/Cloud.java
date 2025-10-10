package ru.vsu.cs.boldyrev.model.shape;

import ru.vsu.cs.boldyrev.model.interfaces.IShape;
import ru.vsu.cs.boldyrev.model.structure.MovableShape;

import java.awt.*;

public class Cloud extends MovableShape implements IShape {

    private Color color;
    public Cloud(int x, int y, int width, Color color) {
        super(x, y, width);
        this.color = color;
    }

    @Override
    public void draw(Graphics2D gr) {
        gr.setColor(color);
        gr.fillOval(x, y + getVal(0.222), getVal(0.32), getVal(0.32));
        gr.fillOval(x + getVal(0.6767), y + getVal(0.222), getVal(0.32), getVal(0.32));
        gr.fillOval(x + getVal(25.0/99), y, getVal(50.0/99), getVal(50.0/99));
        gr.fillRect(x + getVal(15.0/99), y + getVal(39.5/99), getVal(66.0/99), getVal(14.0/99));
    }
}
