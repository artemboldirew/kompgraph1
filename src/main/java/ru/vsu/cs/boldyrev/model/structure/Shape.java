package ru.vsu.cs.boldyrev.model.structure;

import java.awt.*;

public abstract class Shape {
    protected int x;
    protected int y;
    protected int width;

    protected int getVal(double cnt) {
        return (int)(width * cnt);
    }

    public Shape(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public abstract void draw(Graphics2D g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }
}
