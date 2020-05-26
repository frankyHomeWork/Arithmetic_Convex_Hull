package franky.demo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class PointCreator {
    private static ArrayList<Point> points = new ArrayList<Point>();
    private static ArrayList<Double> points_angle = new ArrayList<Double>();
    private static ArrayList<Double> points_to_min_dis = new ArrayList<Double>();

    // 單例模式
    private static PointCreator pointCreator = new PointCreator();

    private PointCreator() {

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

    public void sortPointByAngle() {
        calculateAngleWithMinPoint();
        for(int i = 0 ; i < points.size() ; i++) {
            for(int j = i + 1 ; j < points.size() ; j++) {
                if (points_angle.get(i) > points_angle.get(j)) {
                    Collections.swap(points_angle, i, j);
                    Collections.swap(points, i, j);
                    Collections.swap(points_to_min_dis, i, j);
                }
            }
        }
    }

    public void calculateAngleWithMinPoint() {
        Point minPoint = findMinPoint();
        for (Point point : points) {
            double angle = calculateAngle(minPoint, point);
            double distance = calculateDistanceP1_to_P2(minPoint, point);

            points_angle.add(angle);
            points_to_min_dis.add(distance);
        }

    }

    public double calculateAngle(Point p1, Point p2) {
        int disY = p2.y - p1.y;
        double hypotenuse = calculateDistanceP1_to_P2(p1, p2);

        if(hypotenuse == 0) {
            return 0;
        }
        double radians = disY / hypotenuse ;

        double angle = Math.toDegrees(Math.asin(radians));

        return angle;
    }

    public double calculateDistanceP1_to_P2(Point p1, Point p2) {
        int disX = p2.x - p1.x;
        int disY = p2.y - p1.y;
        double hypotenuse = Math.sqrt( Math.pow(disX, 2) + Math.pow(disY, 2) );
        return hypotenuse;
    }


    public Point popMinPoint() {
        if (points.isEmpty()) {
            throw new IllegalArgumentException("Is List Empty");
        }
        Point minPoint = findMinPoint();
        for (Point point : points) {
            if (point.equals(minPoint)) {
                points.remove(point);
                break;
            }
        }
        return minPoint;

    }


    public Point findMinPoint() {
        double minDistance = 0;
        Point outPoint = new Point();

        boolean first = true;
        for (Point point : points) {
            double tmpDistance = point.distance(0, 0);
            if (first) {
                minDistance = tmpDistance;
                outPoint = (Point) point.clone();
                first = false;
            } else {
                if (tmpDistance < minDistance) {
                    minDistance = tmpDistance;
                    outPoint = (Point) point.clone();
                }
            }
        }
        return outPoint;
    }


    public void clearPoints() {
        points.clear();
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public static ArrayList<Double> getPoints_angle() {
        return points_angle;
    }

    public static ArrayList<Double> getPoints_to_min_dis() {
        return points_to_min_dis;
    }
}
