import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

import java.awt.*;

public class CollidingBalls extends GraphicsProgram {
    private static final double DIAMETER = 20;
    private GOval ball1;
    private GOval ball2;
    private static final double BALL1_SPEED = 7;
    private static final double BALL2_SPEED = 6;
    public void run() {
        setSize(800, 600);
        ball1 = new GOval(0, (getHeight() - DIAMETER) / 2.0, DIAMETER, DIAMETER);
        ball1.setFilled(true);
        ball1.setColor(Color.GREEN);
        ball1.setFillColor(Color.GREEN);
        ball2 = new GOval(getWidth() - DIAMETER, (getHeight() - DIAMETER) / 2.0, DIAMETER, DIAMETER);
        ball2.setFilled(true);
        ball2.setColor(Color.ORANGE);
        ball2.setFillColor(Color.ORANGE);
        add(ball1);
        add(ball2);

        while (!ball1.getBounds().intersects(ball2.getBounds()) || !ball2.getBounds().intersects(ball1.getBounds())) {
            moveBalls();
            pause(30);
        }

        double crashX = ball2.getX();
        double crashY = ball2.getY();

        remove(ball1);
        remove(ball2);
        GLabel lable = new GLabel("They collided at coords: x = " + crashX + ", y = " + crashY);
        lable.setFont("Arial-24");
        lable.setLocation((getWidth() - lable.getWidth()) / 2.0, (getHeight() - lable.getHeight()) / 2.0);
        add(lable);
        ball1 = null;
        ball2 = null;
    }

    private void moveBalls() {
        if (ball1 != null) {
            ball1.move(BALL1_SPEED, 0);
        }
        if (ball2 != null) {
            ball2.move(-BALL2_SPEED, 0);
        }
    }

    public static void main(String[] args) {
        new CollidingBalls().start(args);
    }
}
