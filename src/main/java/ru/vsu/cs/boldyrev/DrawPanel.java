package ru.vsu.cs.boldyrev;

import ru.vsu.cs.boldyrev.model.provider.CoordinateProvider;
import ru.vsu.cs.boldyrev.model.provider.DayNightProvider;
import ru.vsu.cs.boldyrev.model.shape.Picture;
import ru.vsu.cs.boldyrev.model.interfaces.RepaintObserver;

import java.util.ArrayList;
import java.util.List;
import ru.vsu.cs.boldyrev.model.structure.Shape;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel implements RepaintObserver {
    DayNightProvider dayNightProvider = new DayNightProvider();
    private Picture picture = new Picture(200, 8, dayNightProvider);

    public DrawPanel() {
        Timer timer = new Timer(10, e -> {
            dayNightProvider.nextFrame();
            picture.animate();
            repaint();
        });
        timer.start();
    }


    public void requestRepaint() {
        repaint();
    }


    @Override
    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (List<Shape> sh: picture.getAllObjects()) {
            for (Shape p : sh) {
                p.draw(g);
            }
        }
    }
}
