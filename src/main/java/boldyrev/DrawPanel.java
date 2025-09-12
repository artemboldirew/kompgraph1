package boldyrev;

import boldyrev.model.AnimationManager;
import boldyrev.model.DrawUtils;
import boldyrev.model.interfaces.IMovableShape;
import boldyrev.model.interfaces.IShape;
import boldyrev.model.interfaces.RepaintObserver;
import boldyrev.model.shape.*;

import java.util.ArrayList;
import java.util.List;
import boldyrev.model.shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class DrawPanel extends JPanel implements RepaintObserver {
    private List<Shape> allObjects = new ArrayList<>();
    private Picture picture;
    private Boolean isDay = true;
    AnimationManager anm = new AnimationManager();
    public DrawPanel() {
        initializeShapes();
        Timer timer = new Timer(10, e -> {
            anm.dayNightAnimation(picture);
            cloudAnimation();
            repaint();
        });
        timer.start();
    }

    private void cloudAnimation() {
        picture.cloud1.transform(1, 0);
        picture.cloud2.transform(1, 0);
        picture.cloud3.transform(1, 0);
        if (picture.cloud3.getX() > 640) {
            picture.cloud1.moveTo(-180, 190);
            picture.cloud2.moveTo(-80, 220);
            picture.cloud3.moveTo(-200, 270);
        }
    }

//    private void dayNightAnimation(int speed) {
//        int start = 81;
//        int end = 800;
//        int step = (end - start) / speed;
//        if (isDay) {
//            if (picture.sun.getY() > 800) {
//                isDay = false;
//            } else {
//                picture.sun.transform(0, step);
//            }
//        } else {
//            if (picture.moon.getY() < 81);
//        }
//    }


    public void moonColor(double progress) {
        Color skyStart = new Color(108, 166, 188);
        Color skyEnd = new Color(6, 33, 43);
        Color sunEnd = new Color(235, 103, 38);
        RadialGradientPaint gradient = new RadialGradientPaint(
                new Point(picture.sun.getX() + 58, picture.sun.getY() + 58),    // Центральная точка
                116 + (float)(200*(1 - progress)),           // Радиус
                new float[]{0.0f, 1.0f}, // Позиции цветов (0.0 - центр, 1.0 - край)
                //DrawUtils.interpolateColor(sunEnd, Color.YELLOW, progress)
                new Color[]{Color.WHITE, DrawUtils.interpolateColor(skyEnd, skyStart, progress)} // Цвета
        );
        picture.bgSky.setGradient(gradient);
    }


    public void sunColor(double progress) {
        Color skyStart = new Color(108, 166, 188);
        Color skyEnd = new Color(6, 33, 43);
        Color sunEnd = new Color(235, 103, 38);
        RadialGradientPaint gradient = new RadialGradientPaint(
                new Point(picture.sun.getX() + 58, picture.sun.getY() + 58),    // Центральная точка
                116 + (float)(200*(1 - progress)),           // Радиус
                new float[]{0.0f, 1.0f}, // Позиции цветов (0.0 - центр, 1.0 - край)
                new Color[]{DrawUtils.interpolateColor(sunEnd, Color.YELLOW, progress), DrawUtils.interpolateColor(skyEnd, skyStart, progress)} // Цвета
        );
        picture.bgSky.setGradient(gradient);
    }

    public void requestRepaint() {
        repaint();
    }

    private void initializeShapes() {
        BackgroundSky bg = new BackgroundSky(0,0,0,0);
        Mountain m2 = new Mountain(270, 437, 390, 350, new Color(33, 106, 138));
        Mountain m1 = new Mountain(-25, 334, 500, 450, new Color(59, 132, 164));
        Hills hills = new Hills(0,0,0);
        Sun sun = new Sun(440, 800, 116, this);
//        Cloud cloud1 = new Cloud(100, 190, 90, this);
//        Cloud cloud2 = new Cloud(200, 220, 90, this);
//        Cloud cloud3 = new Cloud(80, 270, 130, this);
        Cloud cloud1 = new Cloud(-180, 190, 90, this);
        Cloud cloud2 = new Cloud(-80, 220, 90, this);
        Cloud cloud3 = new Cloud(-200, 270, 130, this);
        Tree tree1 = new Tree(21, 526, 148);
        Tree tree2 = new Tree(513, 551, 107);
        Tree tree3 = new Tree(439, 680, 132);
        Moon moon = new Moon(440, 800, 116, this);
        allObjects.add(bg);
        allObjects.add(sun);
        allObjects.add(moon);
        allObjects.add(m2);
        allObjects.add(m1);
        allObjects.add(hills);
        allObjects.add(cloud1);
        allObjects.add(cloud2);
        allObjects.add(cloud3);
        allObjects.add(tree1);
        allObjects.add(tree2);
        allObjects.add(tree3);
        this.picture = new Picture(m1, m2, sun, cloud1, cloud2, cloud3, tree1, tree2, tree2, bg, moon);
        sunColor(1.0);
    }

    @Override
    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (Shape sh: allObjects) {
            sh.draw(g);
        }
    }
}
