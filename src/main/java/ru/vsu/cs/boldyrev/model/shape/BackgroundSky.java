package ru.vsu.cs.boldyrev.model.shape;

import ru.vsu.cs.boldyrev.Config;
import ru.vsu.cs.boldyrev.model.DayNightProvider;
import ru.vsu.cs.boldyrev.model.interfaces.IShape;
import ru.vsu.cs.boldyrev.model.structure.Shape;
import ru.vsu.cs.boldyrev.model.util.ColorUtil;

import java.awt.*;

public class BackgroundSky extends Shape implements IShape {
    private int height;
    private RadialGradientPaint gradient;
    private DayNightProvider dayNightProvider;
    public BackgroundSky(int x, int y, int width, int height, DayNightProvider dayNightProvider) {
        super(x, y, width);
        this.height = height;
        this.dayNightProvider = dayNightProvider;
    }
    @Override
    public void draw(Graphics2D gr) {
        Color backgroundSky = new Color(108, 166, 188);
        //gr.setColor(backgroundSky);
        int y = (int) (81 + (900 - 81)* (1 - dayNightProvider.getProgress()));
        RadialGradientPaint grad = getGradient(dayNightProvider.getProgress(), new Point(300, y));

        gr.setPaint(grad);
        gr.fillRect(0,0, Config.width, Config.height);
    }

    public RadialGradientPaint getGradient(double progress, Point p) {
        float radius = progress < 0.5 ? 116 + (float)(800*(1 - progress)) : 80;
        RadialGradientPaint gradient = new RadialGradientPaint(
                p,    // Центральная точка
                radius,           // Радиус
                new float[]{0.0f, 1.0f}, // Позиции цветов (0.0 - центр, 1.0 - край)
                dayNigthColors(progress)
                //new Color[]{DrawUtils.interpolateColor(sunEnd, Color.YELLOW, progress), DrawUtils.interpolateColor(skyEnd, skyStart, progress)} // Цвета
        );
        return gradient;
    }

    private Color[] dayNigthColors(double progress) {
        Color skyStart = new Color(108, 166, 188);
        Color skyEnd = new Color(6, 33, 43);
        Color sunEnd = new Color(235, 103, 38);
        if (progress < 0.5) {
            return new Color[]{ColorUtil.interpolateColor(sunEnd, Color.YELLOW, progress), ColorUtil.interpolateColor(skyEnd, skyStart, progress)};
        } else {
            return new Color[]{Color.WHITE, skyEnd};
        }
    }

    public void setGradient(RadialGradientPaint gradient) {
        this.gradient = gradient;
    }


}
