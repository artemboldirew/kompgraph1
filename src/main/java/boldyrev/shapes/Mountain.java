package boldyrev.shapes;

import java.awt.*;

public class Mountain {
    private Graphics2D gr;
    private int x;
    private int y;
    private int width;
    private int height;
    private Color c;

    public Mountain(Graphics2D gr, int x, int y, int width, int height, Color c) {
        this.gr = gr;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
    }

    private int f(int k, int x, int b) {
        return k*x + b;
    }


    public void drawMountain() {
        Primitives.drawTriangle(gr, x, y, width, height, c);
        Primitives.drawTriangle(gr, (int) (x + Math.round(width*(42.5/100))), y, (int)(width*0.15), (int)(height*0.15), Color.WHITE);
    }
}
