import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

public class HitBall extends GraphicsProgram {
    private GOval ball;
    private static final double DIAMETER = 50;
    private double speed = 6;
    private boolean keepPlaying = true;
    public void run() {
        setSize(800, 600);
        ball = new GOval((getWidth() - DIAMETER) / 2.0, (getHeight() - DIAMETER) / 2.0, DIAMETER, DIAMETER);
        ball.setFilled(true);
        add(ball);
        addMouseListeners();

        while (keepPlaying) {
            moveBall();
            pause(30);
        }

        if (ball != null) {
            remove(ball);
            ball = null;
            GLabel label = new GLabel("Ви виграли!");
            label.setFont("Arial-28");
            label.setLocation((getWidth() - label.getWidth()) / 2.0, (getHeight() - label.getHeight()) / 2.0);
            add(label);
        }
    }

    private void moveBall() {
        if (ball != null) {
            double quater = (double) getWidth()/4;

            ball.move(speed, 0);
            if (ball.getX() + ball.getWidth() >= ((getWidth() - DIAMETER) / 2.0) + quater) {
                speed = -Math.abs(speed);
            }
            if (ball.getX() <= getX() + quater) {
                speed = Math.abs(speed);
            }
        } else return;
    }

    public void mouseClicked(MouseEvent e) {
        if (ball != null && ball.contains(e.getX(), e.getY())) {
            keepPlaying = false;
        }
    }

    public static void main(String[] args) {
        new HitBall().start(args);
    }
}
