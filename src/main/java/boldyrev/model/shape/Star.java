package boldyrev.model.shape;

import boldyrev.model.DayNightProvider;
import boldyrev.model.interfaces.IShape;
import boldyrev.model.structure.Shape;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Star extends Shape implements IShape {
    private DayNightProvider dayNightProvider;
    public Star(int x, int y, int width, DayNightProvider dayNightProvider) {
        super(x, y, width);
        this.dayNightProvider = dayNightProvider;
        //this.radius = radius;
    }

    @Override
    public void draw(Graphics2D g) {
        /*if dayProv.isDay() {
           return;
        }*/
        int height = (int) (1.33*width);
        int w = (int) (0.5*width);
        int h = (int) (0.5*height);
        Rectangle2D rect = new Rectangle(x, y, width, height);
        Area startArea = new Area(rect);
        Ellipse2D[] circles = {
                new Ellipse2D.Double(x - w, y - h, width, height),
                new Ellipse2D.Double(x + w, y - h, width, height),
                new Ellipse2D.Double(x - w, y + h, width, height),
                new Ellipse2D.Double(x + w, y + h, width, height)
        };
        for (Ellipse2D el : circles) {
            Area elipsArea = new Area(el);
            startArea.subtract(elipsArea);
        }

        g.setColor(Color.WHITE);
        g.fill(startArea);
    }

}
