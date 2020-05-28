package franky.demo;

import java.awt.*;
import java.util.ArrayList;

public class PrintCircleCanvas extends Canvas {

    private int canvasWidth = 800;
    private int canvasHight = 800;

    private ArrayList<Point> points = new ArrayList<Point>();

    public PrintCircleCanvas() {
        setSize(this.canvasWidth, this.canvasHight);
    }

    public void paint(Graphics g) {
        this.clearAll();
        int circle_size = 5;
        for (Point point : points) {
            g.setColor(Color.RED);
            g.fillOval((int) point.getX(), (int) point.getY(), circle_size, circle_size);
            String pointStr = "(" + (int) point.getX() + ", " + (int) point.getY() +")";
            g.setColor(Color.BLACK);
            g.drawString(pointStr, (int) point.getX(), (int) point.getY());
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

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
}




