package boldyrev;

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
    public DrawPanel() {
        initializeShapes();
        Timer timer = new Timer(10, e -> {
            sunAnimation(200);
            repaint();
        });
        timer.start();
    }

    private void sunAnimation(int speed) {
        int start = 81;
        int end = 689;
        int step = (end - start) / speed;
        Sun sun = picture.sun;
        int current = sun.getY();
        if (current > 689) {
            isDay = false;
            sun.moveTo(sun.getX(), 689);
        }
        if (current < 81) {
            isDay = true;
            sun.moveTo(sun.getX(), 81);
        }
        if (isDay) {
            sun.transform(0, step);
        } else {
            sun.transform(0, -step);
        }
        sunColor();
    }

    public void sunColor() {
        RadialGradientPaint gradient = new RadialGradientPaint(
                new Point(picture.sun.getX() + 58, picture.sun.getY() + 58),    // Центральная точка
                116,           // Радиус
                new float[]{0.0f, 1.0f}, // Позиции цветов (0.0 - центр, 1.0 - край)
                new Color[]{Color.YELLOW, new Color(108, 166, 188)} // Цвета
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
        Sun sun = new Sun(440, 81, 116, this);
        Cloud cloud1 = new Cloud(100, 190, 90, this);
        Cloud cloud2 = new Cloud(200, 220, 90, this);
        Cloud cloud3 = new Cloud(80, 270, 130, this);
        Tree tree1 = new Tree(21, 526, 148);
        Tree tree2 = new Tree(513, 551, 107);
        Tree tree3 = new Tree(439, 680, 132);
        allObjects.add(bg);
        allObjects.add(sun);
        allObjects.add(m2);
        allObjects.add(m1);
        allObjects.add(hills);
        allObjects.add(cloud1);
        allObjects.add(cloud2);
        allObjects.add(cloud3);
        allObjects.add(tree1);
        allObjects.add(tree2);
        allObjects.add(tree3);
        this.picture = new Picture(m1, m2, sun, cloud1, cloud2, cloud3, tree1, tree2, tree2, bg);
        sunColor();
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
//        Color backgroundSky = new Color(108, 166, 188);
//        Color snow = new Color(198, 219, 214);
//        Color snow2 = new Color(198, 219, 214);
//        g.setColor(backgroundSky);
//        g.fillRect(0,0,Config.width, Config.height);
//        Mountain m2 = new Mountain(270, 437, 390, 350, new Color(33, 106, 138));
//        m2.draw(g);
//        Mountain m1 = new Mountain(-25, 334, 500, 450, new Color(59, 132, 164));
//        m1.draw(g);
//        g.setColor(snow);
//        g.fillOval(-380, 663, 1065, 1065);
//        g.fillOval(-63, 665, 1065, 1065);
//        Sun sun = new Sun(440, 81, 116, this);
//        sun.draw(g);
//        Cloud cloud1 = new Cloud(100, 190, 90, this);
//        cloud1.draw(g);
//        Cloud cloud2 = new Cloud(200, 220, 90, this);
//        cloud2.draw(g);
//        Cloud cloud3 = new Cloud(80, 270, 130, this);
//        cloud3.draw(g);
//        Tree tree1 = new Tree(21, 526, 148);
//        tree1.draw(g);
//        Tree tree2 = new Tree(513, 551, 107);
//        tree2.draw(g);
//        Tree tree3 = new Tree(439, 680, 132);
//        tree3.draw(g);
    }
}
