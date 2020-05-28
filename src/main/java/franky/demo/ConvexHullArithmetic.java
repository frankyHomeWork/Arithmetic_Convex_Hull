package franky.demo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ConvexHullArithmetic {

    private ArrayList<Point> originalPoints = new ArrayList<Point>();
    private Point minPointInOriginalPoints = null;

    private ArrayList<Point> points_without_minPoint = new ArrayList<Point>();
    private ArrayList<Double> points_angle = new ArrayList<Double>();
    private ArrayList<Double> points_to_min_dis = new ArrayList<Double>();

    public ConvexHullArithmetic(ArrayList<Point> points) {
        this.originalPoints = points;
    }

    public ArrayList<Point> getLinkLine() {
        this.sortPointByAngle();
        //以下參考 http://wiki.csie.ncku.edu.tw/acm/course/Convex%20Hull  這方法p0 p1 p2 會先被放入
        Stack<Point> stack = new Stack<Point>();
        stack.push(minPointInOriginalPoints); // p0 會先被放入

        boolean isStep1_And_Step2 = true;
        int step_count = 0;

        for (Point point : points_without_minPoint) {
            if (isStep1_And_Step2) { // p1 p2
                stack.push(point);
                step_count++;
                if (step_count >= 2) {
                    isStep1_And_Step2 = false;
                }
                continue;
            }

            stack.push(point);
            while (true) {
                int nowPointIndex = stack.size() - 1;
                Point nowPoint = stack.get(nowPointIndex);
                Point lastPoint = stack.get(nowPointIndex - 1);
                Point lastLastPoint = stack.get(nowPointIndex - 2);

                double threePointAngle = calculate3PointsAngle(lastLastPoint, lastPoint, nowPoint); // 算夾角
                if (threePointAngle < 180 || Double.isNaN(threePointAngle)) {
                    stack.remove(lastPoint);
                } else {
                    break;
                }
            }
        }
        stack.push(minPointInOriginalPoints);

        return new ArrayList<Point>(stack);
    }

    public double calculate3PointsAngle(Point p1, Point p2, Point p3) {
        return getDegree(p2.x, p2.y, p1.x, p1.y, p3.x, p3.y);
    }

    private double getDegree(int vertexPointX, int vertexPointY, int point0X, int point0Y, int point1X, int point1Y) {
        //code copy from https://www.twblogs.net/a/5c015ea0bd9eee7aed33aa0f
        //向量的點乘
        int vector = (point0X - vertexPointX) * (point1X - vertexPointX) + (point0Y - vertexPointY) * (point1Y - vertexPointY);


        double v1_x = point0X - vertexPointX;
        double v1_y = point0Y - vertexPointY;

        double v2_x = point1X - vertexPointX;
        double v2_y = point1Y - vertexPointY;

        //向量的模乘
        double sqrt = Math.sqrt(
                (Math.abs(Math.pow(v1_x, 2)) + Math.abs(Math.pow(v1_y, 2)))
                        * (Math.abs(Math.pow(v2_x, 2)) + Math.abs(Math.pow(v2_y, 2))));

        //反餘弦計算弧度

        if (sqrt <= 0) {
            return 0;
        }

        double radian = Math.acos(vector / sqrt);

        double angle = (180 * radian / Math.PI);

        int ax = point0X - vertexPointX;
        int ay = point0Y - vertexPointY;

        int bx = point1X - vertexPointX;
        int by = point1Y - vertexPointY;

        // 參考 https://medium.com/@zhoukun2588/%E8%AE%A1%E7%AE%97%E4%B8%A4%E5%90%91%E9%87%8F%E7%9A%84%E6%97%8B%E8%BD%AC%E8%A7%92-ab2337aee4e7
        int cross = ax * by - ay * bx;
        if (cross < 0) {
            angle = 360 - angle;
        }
        if (Double.isNaN(angle)) {
            System.out.println("TEST NAN:  sqrt: " + sqrt + ", radian:" + radian);
        }

        return angle;

    }

    public void sortPointByAngle() {
        calculateAngleWithMinPoint();
        for (int i = 0; i < points_without_minPoint.size(); i++) {
            for (int j = i + 1; j < points_without_minPoint.size(); j++) {
                if (points_angle.get(i) > points_angle.get(j)) {
                    Collections.swap(points_angle, i, j);
                    Collections.swap(points_without_minPoint, i, j);
                    Collections.swap(points_to_min_dis, i, j);
                }
            }
        }
    }

    public void calculateAngleWithMinPoint() {
        Point minPoint = findMinPointInOriginalPoints();
        for (Point point : originalPoints) {
            if (minPoint != point) {
                double angle = calculate3PointsAngle(new Point(0, 0), minPoint, point);
                double distance = calculateDistanceP1_to_P2(minPoint, point);
                points_without_minPoint.add((Point) point.clone());
                points_angle.add(angle);
                points_to_min_dis.add(distance);
            }
        }

    }

    public Point findMinPointInOriginalPoints() {
        double minDistance = 0;
        Point outPoint = null;

        boolean first = true;
        for (Point point : originalPoints) {
            double tmpDistance = point.distance(0, 0);
            if (first) {
                minDistance = tmpDistance;
                outPoint = point;
                first = false;
            } else {
                if (tmpDistance < minDistance) {
                    minDistance = tmpDistance;
                    outPoint = point;
                }
            }
        }

        this.minPointInOriginalPoints = outPoint;
        return outPoint;
    }

    public double calculateDistanceP1_to_P2(Point p1, Point p2) {
        int disX = p2.x - p1.x;
        int disY = p2.y - p1.y;
        return Math.sqrt(Math.pow(disX, 2) + Math.pow(disY, 2));
    }

    public Point getMinPointInOriginalPoints() {
        return minPointInOriginalPoints;
    }

    public ArrayList<Point> getPoints_without_minPoint() {
        return points_without_minPoint;
    }

    public ArrayList<Double> getPoints_angle() {
        return points_angle;
    }

    public ArrayList<Double> getPoints_to_min_dis() {
        return points_to_min_dis;
    }
}
