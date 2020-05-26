package franky.demo;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PointCreatorTest {

    @Test
    void sortPointByAngle() {
        PointCreator pointCreator = PointCreator.getInstance();
        pointCreator.createRandomPoints(10, 500, 500);
        System.out.println(pointCreator.getPoints().toString());

        System.out.println("min point");
        System.out.println(pointCreator.findMinPoint());
        pointCreator.sortPointByAngle();

        System.out.println("new points");
        System.out.println(pointCreator.getPoints().toString());
        System.out.println(PointCreator.getPoints_angle().toString());
        System.out.println(PointCreator.getPoints_to_min_dis().toString());





    }

    @Test
    void popMinPoint() {
        PointCreator pointCreator = PointCreator.getInstance();
        pointCreator.createRandomPoints(10, 500, 500);
        System.out.println(pointCreator.getPoints().toString());

        System.out.println("min point");
        System.out.println(pointCreator.popMinPoint());

        System.out.println(pointCreator.getPoints().toString());


    }

    @Test
    void calculateAngleWithMinPoint() {
        PointCreator pointCreator = PointCreator.getInstance();
        pointCreator.createRandomPoints(10, 500, 500);
        System.out.println(pointCreator.getPoints().toString());

        System.out.println("min point");
        System.out.println(pointCreator.findMinPoint());

        pointCreator.calculateAngleWithMinPoint();
    }

    @Test
    void calculateAngle() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,1);
        PointCreator pointCreator = PointCreator.getInstance();
        double ans = pointCreator.calculateAngle(p1, p2);
        System.out.print("ans is: ");
        System.out.println(ans);

    }

}