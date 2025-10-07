package boldyrev.model.shape;

import boldyrev.model.DayNightProvider;
import boldyrev.model.fabrics.CloudFactory;
import boldyrev.model.structure.MovableShape;
import boldyrev.model.structure.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Picture {
    private List<Shape> allObjects = new ArrayList<>();
    private List<Cloud> clouds = CloudFactory.getClouds(3);
    private Hills hills = new Hills(0,0,0);
    private Road road = new Road(316, 690, 0);
    private RoadSign roadSign = new RoadSign(323, 832, 50);
    public Mountain m2 = new Mountain(270, 437, 390, 350, new Color(33, 106, 138));
    public Mountain m1 = new Mountain(-25, 334, 500, 450, new Color(59, 132, 164));
    public Sun sun = new Sun(300, 800, 116);
    public Tree tree1 = new Tree(21, 526, 148);
    public Tree tree2 = new Tree(513, 551, 107);
    public Tree tree3 = new Tree(439, 680, 132);
    private DayNightProvider dayNightProvider;
    public BackgroundSky bgSky;



    public Moon moon = new Moon(300, 800, 116);
    public Star star1 = new Star(100, 100, 30, new Color(255,255,255,255));
    public Star star2 = new Star(150, 100, 20, new Color(255,255,255,255));
    public Star star3 = new Star(125, 160, 15, new Color(255,255,255,255));

    public Picture(int treeAmount, int cloudAmount, DayNightProvider dayNightProvider) {
        this.dayNightProvider = dayNightProvider;
        bgSky = new BackgroundSky(0,0,0,0, dayNightProvider);
        allObjects.add(bgSky);
        allObjects.add(star1);
        allObjects.add(star2);
        allObjects.add(star3);
        allObjects.add(sun);
        allObjects.add(moon);
        allObjects.add(m2);
        allObjects.add(m1);
        allObjects.add(hills);
        allObjects.add(roadSign);
        allObjects.add(road);
        allObjects.add(clouds.get(0));
        allObjects.add(clouds.get(1));
        allObjects.add(clouds.get(2));
        allObjects.add(tree1);
        allObjects.add(tree2);
        allObjects.add(tree3);
    }

    private void cloudAnimation() {
        for (Cloud c : clouds) {
            c.transform(1, 0);
        }
        boolean flag = true;
        for (Cloud c : clouds) {
            if (c.getX() > 700) {
                clouds = CloudFactory.getClouds(3);
            }
        }
    }

    public List<Shape> getAllObjects() {
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
        MovableShape sh = progress < 0.5 ? sun : moon;
        sh.moveTo(300, (int) (81 + (900 - 81)*(1-bbb)));
    }


}
