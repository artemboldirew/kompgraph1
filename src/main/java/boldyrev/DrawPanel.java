package boldyrev;

import boldyrev.shapes.Cloud;
import boldyrev.shapes.Mountain;
import boldyrev.shapes.Sun;
import boldyrev.shapes.Tree;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    public DrawPanel() {
    }

    protected void requestRepaint() {
        repaint();
    }

    @Override
    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Color backgroundSky = new Color(108, 166, 188);
        Color snow = new Color(198, 219, 214);
        Color snow2 = new Color(198, 219, 214);
        g.setColor(backgroundSky);
        g.fillRect(0,0,Config.width, Config.height);
        Mountain m2 = new Mountain(g, 270, 437, 390, 350, new Color(33, 106, 138));
        m2.drawMountain();
        Mountain m1 = new Mountain(g, -25, 334, 500, 450, new Color(59, 132, 164));
        m1.drawMountain();
        g.setColor(snow);
        g.fillOval(-380, 663, 1065, 1065);
        g.fillOval(-63, 665, 1065, 1065);
        Sun sun = new Sun(g, 440, 81, 116);
        sun.drawSun();
        Cloud cloud1 = new Cloud(g, 100, 190, 90);
        cloud1.drawCloud();
        Cloud cloud2 = new Cloud(g, 200, 220, 90);
        cloud2.drawCloud();
        Cloud cloud3 = new Cloud(g, 80, 270, 130);
        cloud3.drawCloud();
        Tree tree1 = new Tree(g, 21, 526, 148);
        tree1.drawTree();
        Tree tree2 = new Tree(g, 513, 551, 107);
        tree2.drawTree();
        Tree tree3 = new Tree(g, 439, 680, 132);
        tree3.drawTree();
    }
}
