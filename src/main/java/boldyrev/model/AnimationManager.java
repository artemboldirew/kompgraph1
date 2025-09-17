package boldyrev.model;

import boldyrev.model.structure.MovableShape;
import boldyrev.model.shape.Picture;
import boldyrev.model.util.DrawUtils;

import java.awt.*;

public class AnimationManager {
    private int noonCnt;
    private boolean isNotOnTop = true;
    private boolean isDay = true;
    RadialGradientPaint gradient;

    public void dayNightAnimation(Picture pic) {
        int top = 81;
        int down = 800;
        MovableShape sh = isDay ? pic.sun : pic.moon;
        double progress = ((down - sh.getY())*1.0) / (down - top);
        RadialGradientPaint grad = getGradient(progress, new Point(sh.getX() + 58, sh.getY() + 58));
        pic.bgSky.setGradient(grad);
        int trans = isDay ? Math.min(255, Math.max(0, (int)((1-(progress + 0.5))*255))) : 255;
        Color starColor = new Color(255,255,255,trans);
        //Color starColor = isDay ? new Color(255,255,255, 0) : new Color(255,255,255, (int)(255*progress));
        pic.star1.setColor(starColor);
        pic.star2.setColor(starColor);
        pic.star3.setColor(starColor);

        if (isNotOnTop) {
            if (sh.getY() > 81) {
                sh.transform(0, -1);
            }
            else {
                sh.moveTo(300, 81);
                noonCnt++;
                if (noonCnt == 100) {
                    isNotOnTop = false;
                    noonCnt = 0;
                }
            }
        } else {
            if (sh.getY() < 900) {
                sh.transform(0, 1);
            }
            else {
                sh.moveTo(300, 900);
                isDay = !isDay;
                isNotOnTop = true;
            }
        }
    }

    private Color[] dayNigthColors(double progress) {
        Color skyStart = new Color(108, 166, 188);
        Color skyEnd = new Color(6, 33, 43);
        Color sunEnd = new Color(235, 103, 38);
        if (isDay) {
            return new Color[]{DrawUtils.interpolateColor(sunEnd, Color.YELLOW, progress), DrawUtils.interpolateColor(skyEnd, skyStart, progress)};
        } else {
            return new Color[]{Color.WHITE, skyEnd};
        }
    }

    public RadialGradientPaint getGradient(double progress, Point p) {
        float radius = isDay ? 116 + (float)(800*(1 - progress)) : 80;
        RadialGradientPaint gradient = new RadialGradientPaint(
                p,    // Центральная точка
                radius,           // Радиус
                new float[]{0.0f, 1.0f}, // Позиции цветов (0.0 - центр, 1.0 - край)
                dayNigthColors(progress)
                //new Color[]{DrawUtils.interpolateColor(sunEnd, Color.YELLOW, progress), DrawUtils.interpolateColor(skyEnd, skyStart, progress)} // Цвета
        );
        return gradient;
    }
}
