import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;

import java.awt.event.MouseEvent;

public class DrawObjectUserClicks extends GraphicsProgram {
    RandomGenerator generator = RandomGenerator.getInstance();
    public void run() {
        this.setSize(800, 600);
        addMouseListeners();
    }

    public void mouseClicked(MouseEvent e) {
        int randInt = generator.nextInt(1, 3);
        if (randInt == 1) {
            GOval circle = new GOval(40, 40);
            circle.setLocation( e.getX() - circle.getWidth() / 2.0, e.getY() - circle.getHeight() / 2.0);
            circle.setFilled(true);
            circle.setColor(Color.ORANGE);
            add(circle);
        } else if (randInt == 2) {
            GRect square = new GRect(40, 40);
            square.setLocation( e.getX() - square.getWidth() / 2.0, e.getY() - square.getHeight() / 2.0);
            square.setFilled(true);
            square.setColor(Color.YELLOW);
            add(square);
        } else {
            GRect rect = new GRect(40, 20);
            rect.setLocation( e.getX() - rect.getWidth() / 2.0, e.getY() - rect.getHeight() / 2.0);
            rect.setFilled(true);
            rect.setColor(Color.RED);
            add(rect);
        }
    }

    public static void main(String[] args) {
        new DrawObjectUserClicks().start();
    }
}
