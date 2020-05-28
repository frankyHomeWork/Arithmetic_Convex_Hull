package franky.demo;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ConvexHullArithmeticTest {

    @Test
    void sortPointByAngle() {
        PointCreator pointCreator = PointCreator.getInstance();
        pointCreator.createRandomPoints(10, 500, 500);
        ConvexHullArithmetic convexHullArithmetic = new ConvexHullArithmetic(pointCreator.getPoints());
        convexHullArithmetic.sortPointByAngle();

        System.out.println("getMinPointInOriginalPoints()");
        System.out.println(convexHullArithmetic.getMinPointInOriginalPoints());

        System.out.println("getPoints_without_minPoint()");
        System.out.println(convexHullArithmetic.getPoints_without_minPoint());

        System.out.println("getPoints_angle()");
        System.out.println(convexHullArithmetic.getPoints_angle());



    }

    @Test
    void calculateAngleWithMinPoint() {
    }

    @Test
    void findMinPointInOriginalPoints() {
    }

    @Test
    void calculateAngle() {
    }

    @Test
    void calculateDistanceP1_to_P2() {
    }

    @Test
    void calculate3PointsAngle() {
        PointCreator pointCreator = PointCreator.getInstance();
        pointCreator.createRandomPoints(10, 500, 500);

        ConvexHullArithmetic convexHullArithmetic = new ConvexHullArithmetic(pointCreator.getPoints());

        Double test = convexHullArithmetic.calculate3PointsAngle(new Point(3, 2),new Point(2, 2),new Point(3, 3));
        System.out.println(test);


    }

    @Test
    void getLinkLine() {
        PointCreator pointCreator = PointCreator.getInstance();
        pointCreator.createRandomPoints(10, 500, 500);
        ConvexHullArithmetic convexHullArithmetic = new ConvexHullArithmetic(pointCreator.getPoints());
        convexHullArithmetic.getLinkLine();

    }
}