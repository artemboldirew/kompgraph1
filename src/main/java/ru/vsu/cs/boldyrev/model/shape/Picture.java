package ru.vsu.cs.boldyrev.model.shape;

import ru.vsu.cs.boldyrev.model.DayNightProvider;
import ru.vsu.cs.boldyrev.model.factory.CloudFactory;
import ru.vsu.cs.boldyrev.model.structure.MovableShape;
import ru.vsu.cs.boldyrev.model.structure.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Picture {
    private int CLOUD_AMOUNT = 6;

    private DayNightProvider dayNightProvider;
    private List<List<Shape>> allObjects = new ArrayList<>();

    private List<Shape> clouds = CloudFactory.getClouds(CLOUD_AMOUNT);
    private List<Shape> hiils = List.of(new Hills(0,0,0));
    private List<Shape> road = List.of(new Road(316, 690, 0));
    private List<Shape> mountains = List.of(new Mountain(270, 437, 390, 350, new Color(33, 106, 138)),
            new Mountain(-25, 334, 500, 450, new Color(59, 132, 164)));
    private List<Shape> roadSign = List.of(new RoadSign(323, 832, 50));
    private List<Shape> sunMoon;
    private List<Shape> trees = List.of(new Tree(21, 526, 148), new Tree(513, 551, 107), new Tree(439, 680, 132));
    private List<Shape> bgSky;
    private List<Shape> stars;

    public Picture(int treeAmount, int cloudAmount, DayNightProvider dayNightProvider) {
        this.dayNightProvider = dayNightProvider;
        sunMoon = List.of(new SunMoon(300, 800, 116, dayNightProvider));
        bgSky = List.of(new BackgroundSky(0,0,0,0, dayNightProvider));
        stars = List.of(new Star(100, 100, 30, dayNightProvider), new Star(150, 100, 20, dayNightProvider), new Star(125, 160, 15, dayNightProvider));
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
//                clouds = CloudFactory.getClouds(3);
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
        double mp = dayNightProvider.getProgress() > 0.5 ? progress / 2 : progress;
        double bbb = dayNightProvider.getProgress() < 0.5 ? progress * 2 : (progress - 0.5) * 2;
        int start = 81;
        int end = 900;
        MovableShape sh = (MovableShape) sunMoon.get(0);
        if (progress < 0.25) {
            double curP = progress * 4;
            sh.moveTo(300, (int) (81 + (900 - 81)*(1 - curP)));
        }
        else if (progress < 0.5) {
            double curP = (progress - 0.25) / 0.25;
            sh.moveTo(300, (int) (81 + (900 - 81)*curP));
        }
        else if (progress < 0.75) {
            double curP = (progress - 0.5) / 0.25;
            sh.moveTo(300, (int) (81 + (900 - 81)*(1 - curP)));
        }
        else {
            double curP = (progress - 0.75) / 0.25;
            sh.moveTo(300, (int) (81 + (900 - 81)*curP));
        }
        //sh.moveTo(300, (int) (81 + (900 - 81)*(1-bbb)));
    }


}
