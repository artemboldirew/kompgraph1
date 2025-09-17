package boldyrev.model;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.List;
import java.util.ArrayList;

public class Primitives {
    public static void drawTriangle(Graphics2D gr, int x, int y, int width, int height, Color color) {
        gr.setColor(color);
        int[] xP = {x, x + width/2, x + width};
        int[] yP = {y + height, y, y + height};
        gr.fillPolygon(xP, yP, 3);
    }

    public static Point calculateCubicBezierPoint(Point P0, Point P1, Point P2, Point P3, double t) {
        // Ограничиваем параметр t в диапазоне [0, 1]
        t = Math.max(0, Math.min(1, t));

        // Формула кубической кривой Безье:
        // B(t) = (1-t)³ * P0 + 3*(1-t)²*t * P1 + 3*(1-t)*t² * P2 + t³ * P3
        double oneMinusT = 1.0 - t;
        double oneMinusTSquared = oneMinusT * oneMinusT;
        double oneMinusTCubed = oneMinusTSquared * oneMinusT;
        double tSquared = t * t;
        double tCubed = tSquared * t;

        double x = oneMinusTCubed * P0.x +
                3 * oneMinusTSquared * t * P1.x +
                3 * oneMinusT * tSquared * P2.x +
                tCubed * P3.x;

        double y = oneMinusTCubed * P0.y +
                3 * oneMinusTSquared * t * P1.y +
                3 * oneMinusT * tSquared * P2.y +
                tCubed * P3.y;

        return new Point((int) Math.round(x), (int) Math.round(y));
    }


    public static List<Point> generateCubicBezierCurve(Point P0, Point P1, Point P2, Point P3, int numSegments) {
        List<Point> curvePoints = new ArrayList<>();

        // Генерируем точки кривой с заданным количеством сегментов
        for (int i = 0; i <= numSegments; i++) {
            double t = (double) i / numSegments;
            Point point = calculateCubicBezierPoint(P0, P1, P2, P3, t);
            curvePoints.add(point);
        }

        return curvePoints;
    }

    public static void fillBetweenCurves(Graphics2D g, List<Point> curve1, List<Point> curve2, Color color) {
        Path2D path = new Path2D.Double();

        // Первая кривая вперед
        path.moveTo(curve1.get(0).x, curve1.get(0).y);
        for (int i = 1; i < curve1.size(); i++) {
            path.lineTo(curve1.get(i).x, curve1.get(i).y);
        }

        // Вторая кривая назад
        path.lineTo(curve2.get(curve2.size()-1).x, curve2.get(curve2.size()-1).y);
        for (int i = curve2.size()-2; i >= 0; i--) {
            path.lineTo(curve2.get(i).x, curve2.get(i).y);
        }

        path.closePath();
        g.setColor(color);
        g.fill(path);
    }
}
