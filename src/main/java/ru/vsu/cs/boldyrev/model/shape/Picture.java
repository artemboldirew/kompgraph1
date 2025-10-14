package ru.vsu.cs.boldyrev.model.shape;

import ru.vsu.cs.boldyrev.model.factory.StarFactory;
import ru.vsu.cs.boldyrev.model.provider.CoordinateProvider;
import ru.vsu.cs.boldyrev.model.provider.DayNightProvider;
import ru.vsu.cs.boldyrev.model.factory.CloudFactory;
import ru.vsu.cs.boldyrev.model.structure.MovableShape;
import ru.vsu.cs.boldyrev.model.structure.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Picture {
    private int CLOUD_AMOUNT;
    private int STAR_AMOUNT;
    private DayNightProvider dayNightProvider;
    private List<List<Shape>> allObjects = new ArrayList<>();

    private List<Shape> clouds;
    private List<Shape> hiils = List.of(new Hills(0,0,0));
    private List<Shape> road = List.of(new Road(316, 690, 0));
    private List<Shape> mountains = List.of(new Mountain(270, 437, 390, 350, new Color(33, 106, 138)),
            new Mountain(-25, 334, 500, 450, new Color(59, 132, 164)));
    private List<Shape> roadSign = List.of(new RoadSign(323, 832, 50));
    private List<Shape> sunMoon;
    private List<Shape> trees = List.of(new Tree(21, 526, 148), new Tree(513, 551, 107), new Tree(439, 680, 132));
    private List<Shape> bgSky;
    private List<Shape> stars;

    public Picture(int starAmount, int cloudAmount, DayNightProvider dayNightProvider) {
        this.CLOUD_AMOUNT = cloudAmount;
        this.STAR_AMOUNT = starAmount;
        this.dayNightProvider = dayNightProvider;
        SunMoon sunMoonObj = new SunMoon(300, 800, 116, dayNightProvider);
        sunMoon = List.of(sunMoonObj);
        bgSky = List.of(new BackgroundSky(0,0,0,0, dayNightProvider, sunMoonObj));
        clouds = CloudFactory.getClouds(CLOUD_AMOUNT);
        stars = StarFactory.getStars(STAR_AMOUNT, dayNightProvider);
        allObjects.add(bgSky);
        allObjects.add(stars);
        allObjects.add(sunMoon);
        allObjects.add(mountains);
        allObjects.add(hiils);
        allObjects.add(roadSign);
        allObjects.add(road);
        allObjects.add(clouds);
        allObjects.add(trees);
    }

    private void cloudAnimation() {
        for (int i = 0; i < clouds.size(); i++) {
            Shape c = clouds.get(i);
            if (c.getX() > 1000) {
                clouds.remove(i);
            }
            MovableShape sh = (MovableShape) c;
            sh.transform(1, 0);
        }
        boolean flag = true;
        for (Shape c : clouds) {
            if (c.getX() < 200) {
                flag = false;
            }
        }
        if (flag) {
            List<Shape> newClouds = CloudFactory.getClouds(CLOUD_AMOUNT);
            clouds.addAll(newClouds);
        }
    }

    public List<List<Shape>> getAllObjects() {
        return allObjects;
    }

    public void animate() {
        cloudAnimation();
        dayNightAnimation();
    }

    private void dayNightAnimation() {
        double progress = dayNightProvider.getProgress();
        MovableShape sh = (MovableShape) sunMoon.getFirst();
        Point sun = CoordinateProvider.getSunCoordinate(progress);
        sh.moveTo(sun.x, sun.y);
    }


}
