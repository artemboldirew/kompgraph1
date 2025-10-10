package ru.vsu.cs.boldyrev.model.fabrics;

import ru.vsu.cs.boldyrev.model.ColorUtil;
import ru.vsu.cs.boldyrev.model.shape.Cloud;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CloudFactory {
    public static List<Cloud> getClouds(int clouds) {
        List<Cloud> result = new ArrayList<>();
        Color cloudGrey = new Color(120, 120, 120);
        int maxX = -180;
        int minX = -500;
        int maxY = 270;
        int minY = 120;
        int maxW = 120;
        int minW = 50;
        for (int i = 0; i < clouds; i++) {
            int randomX = (int)(Math.random() * (maxX - minX + 1)) + minX;
            int randomY = (int)(Math.random() * (maxY - minY + 1)) + minY;
            int randomW = (int)(Math.random() * (maxW - minW + 1)) + minW;
            Cloud cl = new Cloud(randomX, randomY, randomW, ColorUtil.interpolateRGB(Color.WHITE, cloudGrey, (float) Math.random()));
            result.add(cl);
        }
        return result;
    }
}
