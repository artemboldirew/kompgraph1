package ru.vsu.cs.boldyrev.model.provider;

public class DayNightProvider {
    private int framesPerAnimation = 3800;
    private double progress = 1.0;

    public void nextFrame() {
        double step = (1.0 / framesPerAnimation);
        progress += step;
        progress = progress > 1.0 ? 0 : progress;
    }

    public double getProgress() {
        return progress;
    }
}
