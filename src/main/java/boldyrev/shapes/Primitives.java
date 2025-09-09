package boldyrev.shapes;

import java.awt.*;

public class Primitives {
    public static void drawTriangle(Graphics2D gr, int x, int y, int width, int height, Color color) {
        gr.setColor(color);
        int[] xP = {x, x + width/2, x + width};
        int[] yP = {y + height, y, y + height};
        gr.fillPolygon(xP, yP, 3);
    }
}
