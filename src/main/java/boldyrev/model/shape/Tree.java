package boldyrev.model.shape;

import boldyrev.model.Primitives;
import boldyrev.model.interfaces.IShape;

import java.awt.*;

public class Tree extends Shape implements IShape {

    public Tree(int x, int y, int width) {
        super(x, y, width);
    }

    @Override
    public void draw(Graphics2D gr) {
        Color treeColor = new Color(26, 89, 124);
        gr.setColor(treeColor);
        Primitives.drawTriangle(gr, x, y + getVal(59.0/148), width, getVal(125.0/148), treeColor);
        Primitives.drawTriangle(gr, x + getVal(6.0/148), y + getVal(31.0/148), getVal(136.0/148), getVal(99.0/148), treeColor);
        Primitives.drawTriangle(gr, x + getVal(25.0/148), y , getVal(98.0/148), getVal(75.0/148), treeColor);
        gr.fillRect(x + getVal(65.0/148), y + getVal(168.0/148), getVal(17.0/148), getVal(52.0/148));
    }
}
