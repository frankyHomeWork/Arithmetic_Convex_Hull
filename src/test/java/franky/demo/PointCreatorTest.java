package franky.demo;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PointCreatorTest {

    @Test
    void createRandomPoints() {
        PointCreator pointCreator = PointCreator.getInstance();
        pointCreator.createRandomPoints(10, 500, 500);
        System.out.println("points");
        System.out.println(pointCreator.getPoints().toString());
    }
}