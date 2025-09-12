package boldyrev.model;

import boldyrev.model.shape.MovableShape;
import boldyrev.model.shape.Picture;
import boldyrev.model.shape.Sun;

import java.awt.*;

public class AnimationManager {
    private int noonCnt;
    private boolean isNotOnTop = true;
    private boolean isDay = true;
    RadialGradientPaint gradient;

    public void dayNightAnimation(Picture pic) {
        int top = 81;
        int down = 900;
        MovableShape sh = isDay ? pic.sun : pic.moon;
        double progress = ((down - sh.getY())*1.0) / (down - top);
        RadialGradientPaint grad = getGradient(progress, new Point(sh.getX() + 58, sh.getY() + 58));
        pic.bgSky.setGradient(grad);
        if (isNotOnTop) {
            if (sh.getY() > 81) {
                sh.transform(0, -1);
            }
            else {
                sh.moveTo(440, 81);
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
                sh.moveTo(440, 900);
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
        RadialGradientPaint gradient = new RadialGradientPaint(
                p,    // Центральная точка
                116 + (float)(200*(1 - progress)),           // Радиус
                new float[]{0.0f, 1.0f}, // Позиции цветов (0.0 - центр, 1.0 - край)
                dayNigthColors(progress)
                //new Color[]{DrawUtils.interpolateColor(sunEnd, Color.YELLOW, progress), DrawUtils.interpolateColor(skyEnd, skyStart, progress)} // Цвета
        );
        return gradient;
    }
}
