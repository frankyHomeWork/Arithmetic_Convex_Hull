package franky.demo;

import java.awt.*;
import java.util.ArrayList;

public class TestCanvas extends Canvas {

    private int canvasWidth = 500;
    private int canvasHight = 500;

    public TestCanvas() {
        setSize(this.canvasWidth, this.canvasHight);
    }

    public void paint(Graphics g) {
        System.out.println("in paint");
    }

    public void printCircle(ArrayList<Point> points) { // how many circle
        this.clearAll();
        int circle_size = 5;
        for (Point point : points) {
            this.getGraphics().fillOval((int) point.getX(), (int) point.getY(), circle_size, circle_size);
            String pointStr = "(" + (int) point.getX() + ", " + (int) point.getY() +")";
            this.getGraphics().drawString(pointStr, (int) point.getX(), (int) point.getY());
        }

    }

    public void linkCircle(ArrayList<Point> points) {

        boolean isFirst = true;
        Point lastPoint = null;

        for (Point point : points) {
            if (isFirst) {
                // pass
                isFirst = false;
            } else {
                this.getGraphics().drawLine(lastPoint.x, lastPoint.y, point.x, point.y);
            }
            lastPoint = point;

        }

    }


    public void clearAll() {
        this.getGraphics().clearRect(0, 0, this.canvasWidth, this.canvasHight); // clear canvas
    }

    public void update(Graphics g) {
        System.out.println("in Update");
    }
}




