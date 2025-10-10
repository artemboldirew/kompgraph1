package ru.vsu.cs.boldyrev.model.shape;

import ru.vsu.cs.boldyrev.model.Primitives;
import ru.vsu.cs.boldyrev.model.structure.Shape;
import java.util.List;
import java.awt.*;

public class Road extends Shape {
    public Road(int x, int y, int width) {
        super(x, y, width);
    }
    //(316;690)
    @Override
    public void draw(Graphics2D g) {
        List<Point> rightSide = Primitives.generateCubicBezierCurve(new Point(316, 690), new Point(668, 727), new Point(24, 855), new Point(385, 959), 10000);
        List<Point> leftSide = Primitives.generateCubicBezierCurve(new Point(316, 690), new Point(600, 728), new Point(1, 810), new Point(198, 959), 10000);
        Polygon road = new Polygon();
        for (Point p : leftSide) {
            road.addPoint(p.x, p.y);
        }
        for (Point p : rightSide) {
            road.addPoint(p.x, p.y);
        }
        Color roadColor = new Color(145, 197, 211);
        Primitives.fillBetweenCurves(g, leftSide, rightSide, roadColor);
    }
}
