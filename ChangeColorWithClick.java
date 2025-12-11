import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ChangeColorWithClick extends GraphicsProgram {
    RandomGenerator generator = RandomGenerator.getInstance();
    GRect rect;
    GRect square;
    GOval circle;
    public void run() {
        setSize(800, 600);

        rect = new GRect(100, 50);
        rect.setLocation(generator.nextDouble(0, getWidth() - rect.getWidth()), generator.nextDouble(0, getHeight() - rect.getHeight()));
        square = new GRect(100, 100);
        square.setLocation(generator.nextDouble(0, getWidth() - square.getWidth()), generator.nextDouble(0, getHeight() - square.getHeight()));
        circle = new GOval(100, 100);
        circle.setLocation(generator.nextDouble(0, getWidth() - circle.getWidth()), generator.nextDouble(0, getHeight() - circle.getHeight()));

        add(rect);
        add(circle);
        add(square);
        addMouseListeners();
    }

    public void mouseClicked(MouseEvent e) {
        if (rect.contains(e.getX(), e.getY())) {
            rect.setFilled(true);
            rect.setFillColor(new Color(generator.nextInt(0, 255), generator.nextInt(0, 255), generator.nextInt(0, 255)));
        } else if (circle.contains(e.getX(), e.getY())) {
            circle.setFilled(true);
            circle.setFillColor(new Color(generator.nextInt(0, 255), generator.nextInt(0, 255), generator.nextInt(0, 255)));
        } else if (square.contains(e.getX(), e.getY())) {
            square.setFilled(true);
            square.setFillColor(new Color(generator.nextInt(0, 255), generator.nextInt(0, 255), generator.nextInt(0, 255)));
        }
    }

    public static void main(String[] args) {
        new ChangeColorWithClick().start(args);
    }
}
