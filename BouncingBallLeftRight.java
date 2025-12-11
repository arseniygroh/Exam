import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class BouncingBallLeftRight extends GraphicsProgram {
    private static final double DIAMETER = 50;
    private static final double GRAVITY = 0.3;
    private double dx;
    private double dy = 3;
    private GOval ball;
    private boolean leftToRight = false;

    public void run() {
        setSize(800, 600);
        if (leftToRight) {
            ball = new GOval(0, 0 , DIAMETER, DIAMETER);
            dx = 2;
        } else {
            ball = new GOval(getWidth() - DIAMETER, 0, DIAMETER, DIAMETER);
            dx = -2;
        }
        ball.setFilled(true);
        add(ball);
        if (leftToRight) {
            while (ball.getX() + ball.getWidth() <= getWidth()) {
                moveBall();
                checkForCollision();
                pause(30);
            }
        } else {
            while (ball.getX() >= 0) {
                moveBall();
                checkForCollision();
                pause(30);
            }
        }
    }

    private void checkForCollision() {
        if (ball.getY() + ball.getHeight() >= getHeight()){
            dy = -dy * 0.8;
        }
    }

    private void moveBall() {
        dy += GRAVITY;
        ball.move(dx, dy);
    }





    public static void main(String[] args) {
        new BouncingBallLeftRight().start(args);
    }
}
