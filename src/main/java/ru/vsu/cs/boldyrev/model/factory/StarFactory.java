package ru.vsu.cs.boldyrev.model.factory;

import ru.vsu.cs.boldyrev.model.provider.DayNightProvider;
import ru.vsu.cs.boldyrev.model.shape.Star;
import ru.vsu.cs.boldyrev.model.structure.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class StarFactory {
    public static List<Point> distributeStars(double areaWidth, double areaHeight,
                                              double startX, double startY,
                                              double starSize, int numberOfStars,
                                              double minDistanceMultiplier) {
        List<Point> stars = new ArrayList<>();
        double minDistance = minDistanceMultiplier * starSize;

        for (int i = 0; i < numberOfStars; i++) {
            Point bestPosition = null;
            double bestDistance = 0;

            // Пробуем несколько случайных позиций и выбираем лучшую
            for (int attempt = 0; attempt < 50; attempt++) {
                double x = startX + Math.random() * areaWidth;
                double y = startY + Math.random() * areaHeight;

                // Проверяем, что звезда не выходит за границы области
                if (x < startX + starSize || x > startX + areaWidth - starSize ||
                        y < startY + starSize || y > startY + areaHeight - starSize) {
                    continue;
                }

                // Находим минимальное расстояние до ближайшей звезды
                double minDistToOthers = Double.MAX_VALUE;
                for (Point star : stars) {
                    double dist = distance(x, y, star.x, star.y);
                    minDistToOthers = Math.min(minDistToOthers, dist);
                }

                // Если это первая звезда или нашли позицию с большим расстоянием
                if (stars.isEmpty() || minDistToOthers > bestDistance) {
                    bestDistance = minDistToOthers;
                    bestPosition = new Point((int) x, (int) y);
                }
            }

            if (bestPosition != null && bestDistance >= minDistance) {
                stars.add(bestPosition);
            } else if (bestPosition != null) {
                // Если не нашли идеальную позицию, но есть какая-то - используем её
                stars.add(bestPosition);
            }
        }

        return stars;
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static List<Shape> getStars(int n, DayNightProvider dayNightProvider) {
        List<Point> coord = distributeStars(630, 700, 10, 10, 1, n, 15);
        List<Shape> res = new ArrayList<>();
        for (Point p : coord) {
            Star s = new Star(p.x, p.y, 1, dayNightProvider);
            res.add((Shape) s);
        }
        return res;
    }
}
