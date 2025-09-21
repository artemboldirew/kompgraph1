package boldyrev.model.shape;

import boldyrev.model.Primitives;
import boldyrev.model.interfaces.IShape;
import boldyrev.model.structure.Shape;

import java.awt.*;

public class Mountain extends Shape implements IShape {

    private int height;
    private Color c;

    public Mountain(int x, int y, int width, int height, Color c) {
        super(x, y, width);
        this.height = height;
        this.c = c;
    }

    @Override
    public void draw(Graphics2D gr) {
        Primitives.drawTriangle(gr, x, y, width, height, c);
        int nw = (int) (width * 0.2);
        int nh = (int) (height * 0.2);
        //Primitives.drawTriangle(gr, (int) (x + Math.round(width*(42.5/100))), y, (int)(width*0.15), (int)(height*0.15), Color.WHITE);
        Polygon p = new Polygon();
        p.addPoint(x + width/2, y);
        p.addPoint(x + getVal(0.4), y + nh);
        p.addPoint(x + getVal(0.4) + nw/3, y + (int) (nh*0.8));
        p.addPoint(x + width/2, y + nh);
        p.addPoint(x + width/2 + (int)(nw*0.15), y + (int) (nh*0.8));
        p.addPoint(x + getVal(0.6), y + nh);
        gr.setColor(Color.WHITE);
        gr.fillPolygon(p);
    }
}
