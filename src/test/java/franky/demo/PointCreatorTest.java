package franky.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointCreatorTest {

    @org.junit.jupiter.api.Test
    void sortPointByAngle() {
        PointCreator pointCreator = PointCreator.getInstance();
        pointCreator.createRandomPoints(10, 500, 500);
        System.out.println(pointCreator.getPoints().toString());

        System.out.println("min point");
        System.out.println(pointCreator.findMinPoint());


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
}