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

    // 要一個使用三個點 算角度的 方法 p1 -> p2 -> p3  算夾角

    // 主要算法 利用stack 依序放入排序好的點 評估要不要放第三點時計算夾角是否大於180 如果大於放入 小於則彈出在序列的最後一個點
    // 在繼續重新評估剛剛要放入的點
    public ArrayList<Point> getLinkLine() { //http://wiki.csie.ncku.edu.tw/acm/course/Convex%20Hull 參考
        this.sortPointByAngle();
        Stack<Point> stack = new Stack<Point>();
        stack.push(minPointInOriginalPoints);

        for (Point point : points_without_minPoint) {
            if(stack.size() < 4) {


            }


        }
        return new ArrayList<Point>(); //

    }

    public double calculate3PointsAngle(Point p1, Point p2, Point p3) {
        return getDegree(p2.x, p2.y, p1.x, p1.y, p3.x, p3.y);
    }

    private double getDegree(int vertexPointX, int vertexPointY, int point0X, int point0Y, int point1X, int point1Y) {
        //code copy from https://www.twblogs.net/a/5c015ea0bd9eee7aed33aa0f
        //向量的點乘
        int vector = (point0X - vertexPointX) * (point1X - vertexPointX) + (point0Y - vertexPointY) * (point1Y - vertexPointY);
        //向量的模乘
        double sqrt = Math.sqrt(
                (Math.abs((point0X - vertexPointX) * (point0X - vertexPointX)) + Math.abs((point0Y - vertexPointY) * (point0Y - vertexPointY)))
                        * (Math.abs((point1X - vertexPointX) * (point1X - vertexPointX)) + Math.abs((point1Y - vertexPointY) * (point1Y - vertexPointY)))
        );
        //反餘弦計算弧度
        double radian = Math.acos(vector / sqrt);
        //弧度轉角度制
        return 180 * radian / Math.PI;
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
            if(minPoint != point) {
                double angle = calculateAngle(minPoint, point);
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

    public double calculateAngle(Point p1, Point p2) { // 算出角度
        int disY = p2.y - p1.y;
        double hypotenuse = calculateDistanceP1_to_P2(p1, p2);

        if (hypotenuse == 0) {
            return 0;
        }
        double radians = disY / hypotenuse;

        return Math.toDegrees(Math.asin(radians));
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
