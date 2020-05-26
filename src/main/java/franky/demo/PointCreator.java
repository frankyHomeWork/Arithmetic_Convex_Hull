package franky.demo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class PointCreator {
    private static ArrayList<Point> points = new ArrayList<Point>();

    // 單例模式
    private static PointCreator pointCreator = new PointCreator();

    private PointCreator() {
        //pass
    }

    public static PointCreator getInstance() {
        return pointCreator;
    }

    public void createRandomPoints(int n_point, int rangeX, int rangeY) {
        for (int i = 0; i < n_point; i++) {
            int x = (int) (Math.random() * rangeX);
            int y = (int) (Math.random() * rangeY);
            Point point = new Point(x, y);
            points.add(point);
        }
    }

    public void clearPoints() {
        points.clear();
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
