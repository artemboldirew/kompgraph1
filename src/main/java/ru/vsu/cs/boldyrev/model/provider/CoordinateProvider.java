package ru.vsu.cs.boldyrev.model.provider;

import java.awt.*;

public class CoordinateProvider {

    public static Point getSunCoordinate(double progress) {
        int start = 81;
        int end = 1000;
        Point sun;
        if (progress < 0.25) {
            double curP = progress * 4;
            sun = new Point(300, (int) (start + (end - start)*(1 - curP)));
        }
        else if (progress < 0.5) {
            double curP = (progress - 0.25) / 0.25;
            sun = new Point(300, (int) (start + (end - start)*curP));
        }
        else if (progress < 0.75) {
            double curP = (progress - 0.5) / 0.25;
            sun = new Point(300, (int) (start + (end - start)*(1 - curP)));
        }
        else {
            double curP = (progress - 0.75) / 0.25;
            sun = new Point(300, (int) (start + (end - start)*curP));
        }
        return sun;
    }
}
