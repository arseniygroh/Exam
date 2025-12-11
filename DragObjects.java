import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

public class DragObjects extends GraphicsProgram {
    private GObject currentObj;
    private double lastX;
    private double lastY;

    public void run() {
        setSize(800, 600);
        GRect rect = new GRect(50, 50, 100, 50);
        GOval circle = new GOval(120, 150, 75, 75);
        GRect square = new GRect(225, 200, 100, 100);
        rect.setFilled(true);
        square.setFilled(true);
        circle.setFilled(true);
        add(rect);
        add(square);
        add(circle);

        addMouseListeners();
    }

    public void mousePressed(MouseEvent e) {
        currentObj = getElementAt(e.getX(), e.getY());
        if (currentObj != null) {
            lastX = e.getX();
            lastY = e.getY();
        }
    }

    public void mouseDragged(MouseEvent e) {
        if (currentObj != null) {
            double dx = e.getX() - lastX;
            double dy = e.getY() - lastY;
            double newX = currentObj.getX() + dx;
            double newY = currentObj.getY() + dy;
            if ((newX >= 0 && (newX + currentObj.getWidth()) <= getWidth()) && (newY >= 0 && (newY + currentObj.getHeight()) <= getHeight())) {
                currentObj.move(dx, dy);
            }

            lastX = e.getX();
            lastY = e.getY();
        }
    }

    public void mouseReleased(MouseEvent e) {
        currentObj = null;
    }

    public static void main(String[] args) {
        new DragObjects().start(args);
    }
}
