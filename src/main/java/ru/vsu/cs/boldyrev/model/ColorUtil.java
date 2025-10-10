package ru.vsu.cs.boldyrev.model;

import java.awt.*;

public class ColorUtil {
    public static Color interpolateRGB(Color color1, Color color2, float factor) {
        if (factor <= 0.0f) return color1;
        if (factor >= 1.0f) return color2;

        factor = Math.max(0.0f, Math.min(1.0f, factor));

        int red = (int) (color1.getRed() + (color2.getRed() - color1.getRed()) * factor);
        int green = (int) (color1.getGreen() + (color2.getGreen() - color1.getGreen()) * factor);
        int blue = (int) (color1.getBlue() + (color2.getBlue() - color1.getBlue()) * factor);
        int alpha = (int) (color1.getAlpha() + (color2.getAlpha() - color1.getAlpha()) * factor);

        return new Color(red, green, blue, alpha);
    }
}
