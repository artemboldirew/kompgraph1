package boldyrev.model.shape;

import boldyrev.model.Primitives;
import boldyrev.model.structure.Shape;
import java.util.List;
import java.awt.*;

public class Road extends Shape {
    public Road(int x, int y, int width) {
        super(x, y, width);
    }
    //(316;690)
    @Override
    public void draw(Graphics2D g) {
        List<Point> rightSide = Primitives.generateCubicBezierCurve(new Point(x, y), new Point(438, 738), new Point(278, 860), new Point(385, 959), 100);
        List<Point> leftSide = Primitives.generateCubicBezierCurve(new Point(x, y), new Point(400, 810), new Point(50, 876), new Point(300, 959), 100);
        Polygon road = new Polygon();
        for (Point p : leftSide) {
            road.addPoint(p.x, p.y);
        }
        for (Point p : rightSide) {
            road.addPoint(p.x, p.y);
        }
        Primitives.fillBetweenCurves(g, leftSide, rightSide, Color.ORANGE);
    }
}
