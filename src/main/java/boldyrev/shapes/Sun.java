package boldyrev.shapes;

import boldyrev.DrawPanel;

import java.awt.*;

public class Sun extends Shape implements IShape{
    private Graphics2D gr;
    private int x;
    private int y;
    private int width;
    private int height;
    private DrawPanel panel;

    public Sun(Graphics2D gr, int x, int y, int width) {
        super();
        this.gr = gr;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }


    public void drawSun() {
        gr.setColor(Color.WHITE);
        gr.fillOval(x, y, width, width);
    }

    public void transform(int dx, int dy, int angle) {
        this.y += dy;
        this.x += dx;
        panel.requestRepa
    }
}
