package ru.vsu.cs.boldyrev.model.shape;

import ru.vsu.cs.boldyrev.model.structure.Shape;

import java.awt.*;

public class RoadSign extends Shape {
    public RoadSign(int x, int y, int width) {
        super(x, y, width);
    }

    @Override
    public void draw(Graphics2D g) {
        Color signColor = new Color(139, 127, 79);
        g.setColor(signColor);
        g.fillRect(x, y, width, getVal(0.66));
        g.fillRect(x + (width - getVal(4.0/50))/2, y + getVal(0.66), getVal(4.0/50), getVal(15.0/50));
        String text1 = "С новым";
        String text2 = "годом!";
        g.setFont(new Font("Arial", Font.BOLD, 8));
        g.setColor(Color.BLACK); // Цвет текста
        g.drawString(text1, x + getVal(0.18), y + getVal(0.28));
        g.drawString(text2, x + getVal(0.27) , y + getVal(0.48));
    }
}
