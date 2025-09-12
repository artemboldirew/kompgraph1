package boldyrev.model.shape;

public class Picture {
    public Mountain m1;
    public Mountain m2;
    public Sun sun;
    public Cloud cloud1;
    public Cloud cloud2;
    public Cloud cloud3;
    public Tree tree1;
    public Tree tree2;
    public Tree tree3;
    public BackgroundSky bgSky;

    public Picture(Mountain m1, Mountain m2, Sun sun, Cloud cloud1, Cloud cloud2, Cloud cloud3, Tree tree1, Tree tree2, Tree tree3, BackgroundSky bgSky) {
        this.m2 = m2;
        this.m1 = m1;
        this.sun = sun;
        this.cloud1 = cloud1;
        this.cloud2 = cloud2;
        this.cloud3 = cloud3;
        this.tree1 = tree1;
        this.tree2 = tree2;
        this.tree3 = tree3;
        this.bgSky = bgSky;
    }
}
