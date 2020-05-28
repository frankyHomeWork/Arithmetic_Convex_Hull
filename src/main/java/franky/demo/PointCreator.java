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

    public void createRandomPoints(int n_point, int range_start, int range_end) {
        for (int i = 0; i < n_point; i++) {

            int range = range_end - range_start;

            int x = range_start + (int) (Math.random() * range) + 1;
            int y = range_start + (int) (Math.random() * range) + 1;
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
