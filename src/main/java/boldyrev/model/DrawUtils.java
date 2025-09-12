package boldyrev.model;

import java.awt.*;

public class DrawUtils {
    public static Color interpolateColor(Color start, Color end, double ratio) {
        ratio = Math.max(0, Math.min(1, ratio)); // Ограничиваем от 0 до 1

        int red = (int) (start.getRed() + ratio * (end.getRed() - start.getRed()));
        int green = (int) (start.getGreen() + ratio * (end.getGreen() - start.getGreen()));
        int blue = (int) (start.getBlue() + ratio * (end.getBlue() - start.getBlue()));
        int alpha = (int) (start.getAlpha() + ratio * (end.getAlpha() - start.getAlpha()));

        return new Color(red, green, blue, alpha);
    }
}
