package ru.vsu.cs.boldyrev.model.shape;

import ru.vsu.cs.boldyrev.model.DayNightProvider;
import ru.vsu.cs.boldyrev.model.interfaces.IShape;
import ru.vsu.cs.boldyrev.model.structure.MovableShape;

import java.awt.*;

public class SunMoon extends MovableShape implements IShape {
    private DayNightProvider dayNightProvider;
    public SunMoon(int x, int y, int width, DayNightProvider dayNightProvider) {
        super(x, y, width);
        this.dayNightProvider = dayNightProvider;
    }

    @Override
    public void draw(Graphics2D gr) {
        double progress = dayNightProvider.getProgress();
        if (progress < 0.5) {
            gr.setColor(Color.WHITE);
            gr.fillOval(x, y, width, width);
        } else {
            Color moonColor = new Color(189,208,228);
            gr.setColor(moonColor);
            gr.fillOval(x, y, width, width);
        }
    }
}
