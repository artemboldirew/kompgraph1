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

    private int getVal(double cnt) {
        return (int)(width * cnt);
    }

    public void drawCloud() {
        gr.setColor(Color.WHITE);
        gr.fillOval(x, y + getVal(0.222), getVal(0.32), getVal(0.32));
        gr.fillOval(x + getVal(0.6767), y + getVal(0.222), getVal(0.32), getVal(0.32));
        gr.fillOval(x + getVal(25.0/99), y, getVal(50.0/99), getVal(50.0/99));
        gr.fillRect(x + getVal(15.0/99), y + getVal(39.5/99), getVal(66.0/99), getVal(14.0/99));
    }

}
