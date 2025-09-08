package boldyrev.shapes;

import java.awt.*;

public class Mountain {
    private Graphics2D gr;
    private int x;
    private int y;
    private int width;
    private int height;

    public Mountain(Graphics2D gr, int x, int y, int width, int height) {
        this.gr = gr;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }


    public void drawMountain() {
        Color main = new Color(59, 132, 164);
        gr.setColor(main);
        int[] xP = {x, x + width/2, x + width};
        int[] yP = {y + height, y, y + height};
        gr.fillPolygon(xP, yP, 3);
        gr.setColor(Color.WHITE);
        int[] xP2 = {x, x + width/2, x + width};
        int[] yP2 = {y + height, y, y + height};
    }
}
