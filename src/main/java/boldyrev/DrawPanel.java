package boldyrev;

import boldyrev.shapes.Mountain;
import boldyrev.shapes.Sun;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    public DrawPanel() {
    }

    @Override
    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        Color backgroundSky = new Color(108, 166, 188);
        Color snow = new Color(198, 219, 214);
        Color snow2 = new Color(198, 219, 214);
        g.setColor(backgroundSky);
        g.fillRect(0,0,Config.width, Config.height);
        Mountain m1 = new Mountain(g, -25, 334, 500, 450);
        m1.drawMountain();
        Mountain m2 = new Mountain(g, 270, 437, 390, 350);
        m2.drawMountain();
        g.setColor(snow);
        g.fillOval(-380, 663, 1065, 1065);
        g.fillOval(-63, 665, 1065, 1065);
        Sun sun = new Sun(g, 440, 81, 116);
        sun.drawSun();
    }
}
