package boldyrev.shapes;

import java.awt.*;

public class Sun {
    private Graphics2D gr;
    private int x;
    private int y;
    private int width;
    private int height;

    public Sun(Graphics2D gr, int x, int y, int width) {
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
}
