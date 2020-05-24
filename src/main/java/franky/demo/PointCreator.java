package franky.demo;

import java.awt.*;
import java.util.ArrayList;

public class PointCreator {
    private static ArrayList<Point> points = new ArrayList<Point>();

    // 單例模式
    private static PointCreator pointCreator = new PointCreator();

    private PointCreator(){

    }

    public static PointCreator getInstance() {
        return pointCreator;
    }

    public void createRandomPoints(int n_point, int rangeX, int rangeY) {
        for(int i = 0 ; i < n_point ; i++) {
            int x = (int)(Math.random() * rangeX);
            int y = (int)(Math.random() * rangeY);
            Point point = new Point(x, y);
            points.add(point);
        }
    }

    public void sortPointByAngle() {
        ArrayList<Point> outPoints = new ArrayList<Point>();

        Point p1 = findMinPoint();
        boolean is_not_find_minPoint = true;

        for(Point point : points) {

            if(is_not_find_minPoint && point.equals(p1)) {
                is_not_find_minPoint = false;
            } else {

                if(outPoints.size() == 0) {
                    outPoints.add(point);
                } else {
                    for(int i = outPoints.size() - 1 ; i >= 0  ; i--) {
                        Point out_point = outPoints.get(i);
                        double hypotenuse = point.distance(out_point);
                        double pointY = out_point.y;
                        double sin_num = hypotenuse / pointY;
                        double degrees = Math.toDegrees(sin_num);

                    }
                }
            }


        }


    }

    public Point findMinPoint() {
        double minDistance = 0;
        Point outPoint = new Point();

        boolean first = true;
        for(Point point : points) {
            double tmpDistance = point.distance(0, 0);
            if( first ) {
                minDistance = tmpDistance;
                outPoint = (Point) point.clone();
                first = false;
            } else {
                if(tmpDistance < minDistance) {
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
}
