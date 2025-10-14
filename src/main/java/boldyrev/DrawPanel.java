package boldyrev;

import boldyrev.model.DayNightProvider;
import boldyrev.model.util.DrawUtils;
import boldyrev.model.interfaces.RepaintObserver;
import boldyrev.model.shape.*;

import java.util.ArrayList;
import java.util.List;
import boldyrev.model.structure.Shape;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel implements RepaintObserver {
    private List<Shape> allObjects = new ArrayList<>();
    DayNightProvider dayNightProvider = new DayNightProvider();
    private Picture picture = new Picture(3, 3, dayNightProvider);
    public DrawPanel() {
        Timer timer = new Timer(100, e -> {
            dayNightProvider.nextFrame();
            picture.animate();
            //anm.dayNightAnimation(picture);
            repaint();
        });
        timer.start();
    }





//    public void moonColor(double progress) {
//        Color skyStart = new Color(108, 166, 188);
//        Color skyEnd = new Color(6, 33, 43);
//        Color sunEnd = new Color(235, 103, 38);
//        RadialGradientPaint gradient = new RadialGradientPaint(
//                new Point(picture.sun.getX() + 58, picture.sun.getY() + 58),    // Центральная точка
//                116 + (float)(200*(1 - progress)),           // Радиус
//                new float[]{0.0f, 1.0f}, // Позиции цветов (0.0 - центр, 1.0 - край)
//                //DrawUtils.interpolateColor(sunEnd, Color.YELLOW, progress)
//                new Color[]{Color.WHITE, DrawUtils.interpolateColor(skyEnd, skyStart, progress)} // Цвета
//        );
//        picture.bgSky.setGradient(gradient);
//    }


//    public void sunColor(double progress) {
//        Color skyStart = new Color(108, 166, 188);
//        Color skyEnd = new Color(6, 33, 43);
//        Color sunEnd = new Color(235, 103, 38);
//        RadialGradientPaint gradient = new RadialGradientPaint(
//                new Point(picture.sun.getX() + 58, picture.sun.getY() + 58),    // Центральная точка
//                116 + (float)(200*(1 - progress)),           // Радиус
//                new float[]{0.0f, 1.0f}, // Позиции цветов (0.0 - центр, 1.0 - край)
//                new Color[]{DrawUtils.interpolateColor(sunEnd, Color.YELLOW, progress), DrawUtils.interpolateColor(skyEnd, skyStart, progress)} // Цвета
//        );
//        picture.bgSky.setGradient(gradient);
//    }

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
