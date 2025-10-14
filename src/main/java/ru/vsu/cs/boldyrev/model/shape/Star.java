package ru.vsu.cs.boldyrev.model.shape;

import ru.vsu.cs.boldyrev.model.provider.DayNightProvider;
import ru.vsu.cs.boldyrev.model.interfaces.IShape;
import ru.vsu.cs.boldyrev.model.structure.Shape;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Star extends Shape implements IShape {
    private DayNightProvider dayNightProvider;
    public Star(int x, int y, int width, DayNightProvider dayNightProvider) {
        super(x, y, width);
        this.dayNightProvider = dayNightProvider;
    }

    @Override
    public void draw(Graphics2D g) {
        int t = 255;
        double progress = dayNightProvider.getProgress();
        if (progress < 0.5) {
            if (progress < 0.25) {
                t = (int) (255 * (1 -((progress) / 0.25)));
            } else {
                t = (int) (255 * ((progress - 0.25) / 0.25));
            }
        } else {
            t = 255;
        }
        t = Math.max(Math.min(255, t), 0);
        Color w = new Color(255, 255, 255, t);
        g.setColor(w);
        g.fillOval(x, y, width, width);
    }

}
