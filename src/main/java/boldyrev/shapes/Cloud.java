package boldyrev.shapes;

import java.awt.*;

public class Cloud {
    private Graphics2D gr;
    private int x;
    private int y;
    private int width;

    public Cloud(Graphics2D gr, int x, int y, int width) {
        this.gr = gr;
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public void drawCloud() {
        gr.setColor(Color.WHITE);
        gr.fillOval(x, (int)(y + width*(2.0/10)), (int)(width*(2.0/10)), (int)(width*(2.0/10)));
        gr.fillOval((int)(x + width*(1.0/10)), (int)(y + width*(1.0/10)), (int)(width*(2.0/10)), (int)(width*(2.0/10)));
        gr.fillOval((int)(x + width*(3.0/10)), (int)(y + width*(2.0/10)), (int)(width*(2.0/10)), (int)(width*(2.0/10)));
        gr.fillRect((int)(x + width*(1.0/10)), (int)(y + width*(2.0/10)), (int)(width*(3.0/10)), (int)(width*(2.0/10)));
    }

}
