package ru.vsu.cs.boldyrev.model.shape;

import ru.vsu.cs.boldyrev.Config;
import ru.vsu.cs.boldyrev.model.provider.CoordinateProvider;
import ru.vsu.cs.boldyrev.model.provider.DayNightProvider;
import ru.vsu.cs.boldyrev.model.interfaces.IShape;
import ru.vsu.cs.boldyrev.model.structure.Shape;
import ru.vsu.cs.boldyrev.model.util.ColorUtil;

import java.awt.*;

public class BackgroundSky extends Shape implements IShape {
    private int height;
    private RadialGradientPaint gradient;
    private DayNightProvider dayNightProvider;
    private SunMoon sunMoon;
    public BackgroundSky(int x, int y, int width, int height, DayNightProvider dayNightProvider, SunMoon sunMoon) {
        super(x, y, width);
        this.height = height;
        this.dayNightProvider = dayNightProvider;
    }
    @Override
    public void draw(Graphics2D gr) {
        double progress = dayNightProvider.getProgress();
        Point sun = CoordinateProvider.getSunCoordinate(progress);
        //gr.setColor(backgroundSky);
        int y = (int) (81 + (900 - 81)* (1 - progress));
        RadialGradientPaint grad = getGradient(progress, new Point(sun.x + 58, sun.y + 58));
        gr.setPaint(grad);
        gr.fillRect(0,0, Config.width, Config.height);
    }

    public RadialGradientPaint getGradient(double progress, Point p) {

        double realP = progress < 0.25 ? (progress / 0.25) : (1 - (progress - 0.25) / 0.25);
        float radius ;//= progress < 0.5 ? 116 + (float)(800*(1 - realP)) : 80;
        if (progress < 0.5) {
            if (progress <= 0.1) {
                radius = (float) (8000*progress);
            } else if (progress <= 0.25){
                radius = (float) (-5260*progress + 1256);
            } else if (progress <= 0.4) {
                radius = (float) (5260*progress - 1256);
            } else {
                radius = (float) (-6840*progress + 3536);
            }
        } else {
            radius = 80;
        }
        radius = (float) Math.max(radius, 0.00001);
        RadialGradientPaint gradient = new RadialGradientPaint(
                p,
                radius,
                new float[]{0.0f, 1.0f},
                dayNigthColors(progress)

        );
        return gradient;
    }

    private Color[] dayNigthColors(double progress) {
        Color skyStart = new Color(108, 166, 188);
        Color skyEnd = new Color(6, 33, 43);
        Color sunEnd = new Color(235, 103, 38);
        if (progress < 0.5) {
            double realP = progress < 0.25 ? (progress / 0.25) : ((1 - (progress - 0.25) / 0.25)*0.8);
            return new Color[]{ColorUtil.interpolateColor(sunEnd, Color.YELLOW, realP), ColorUtil.interpolateColor(skyEnd, skyStart, realP)};
        } else {
            return new Color[]{Color.WHITE, skyEnd};
        }
    }




}
