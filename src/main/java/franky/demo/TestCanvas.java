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

    public void printCircle(int n_circle) { // how many circle
        this.clearAll();
        int circle_size = 10;
        PointCreator pointCreator = PointCreator.getInstance();
        pointCreator.clearPoints();
        pointCreator.createRandomPoints(n_circle, this.canvasWidth, this.canvasHight);
        ArrayList<Point> points = pointCreator.getPoints();

        for (Point point : points) {
            this.getGraphics().fillOval((int) point.getX(), (int) point.getY(), circle_size, circle_size);
        }

        System.out.println(points.toString());
    }

    public void printCircle(ArrayList<Point> points) { // how many circle
        this.clearAll();
        int circle_size = 10;
        for (Point point : points) {
            this.getGraphics().fillOval((int) point.getX(), (int) point.getY(), circle_size, circle_size);
            String pointStr = "" + (int) point.getX() + ", " + (int) point.getY();
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

        System.out.println(points.toString());
    }


    public void clearAll() {
        this.getGraphics().clearRect(0, 0, this.canvasWidth, this.canvasHight); // clear canvas
    }

    public void update(Graphics g) {
        System.out.println("in Update");
    }
}




