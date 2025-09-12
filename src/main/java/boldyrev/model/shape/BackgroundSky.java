package boldyrev.model.shape;

import boldyrev.Config;
import boldyrev.model.interfaces.IShape;

import java.awt.*;

public class BackgroundSky extends Shape implements IShape {
    private int height;
    private RadialGradientPaint gradient;
    public BackgroundSky(int x, int y, int width, int height) {
        super(x, y, width);
        this.height = height;
    }
    @Override
    public void draw(Graphics2D gr) {
        Color backgroundSky = new Color(108, 166, 188);
        //gr.setColor(backgroundSky);
        gr.setPaint(gradient);
        gr.fillRect(0,0, Config.width, Config.height);
    }

    public void setGradient(RadialGradientPaint gradient) {
        this.gradient = gradient;
    }


}
