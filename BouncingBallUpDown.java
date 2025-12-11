import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class BouncingBallUpDown extends GraphicsProgram {
    GOval ball;
    double diameter = 20;
    double dy;
    boolean fromTopToBottom = false;
    double gravity = 0.3;
    public void run() {
        setSize(800, 600);
        if (fromTopToBottom) {
            ball = new GOval((getWidth() - diameter) / 2.0, 0, diameter, diameter);
            dy = 2;
        } else {
            ball = new GOval((getWidth() - diameter) / 2.0, getHeight() - diameter, diameter, diameter);
            dy = -10;
        }
        ball.setFilled(true);
        add(ball);
        while (true) {
            ballBounce();
            pause(30);
        }
    }

    private void ballBounce() {
        dy += gravity;
        ball.move(0, dy);
        if (ball.getY() + ball.getHeight() >= getHeight()) {
            ball.setLocation(ball.getX(), getHeight() - diameter);
            dy = -dy * 0.8;
            if (Math.abs(dy) < 0.5) {
                dy = 0;
            }
        }
        if (ball.getY() <= 0) {
            ball.setLocation(ball.getX(), 0);
            dy = -dy * 0.8;
            if (Math.abs(dy) < 0.5) {
                dy = 0;
            }
        }
    }

    public static void main(String[] args) {
        new BouncingBallUpDown().start(args);
    }
}
