package franky.demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NextStepListener implements ActionListener {
    private ArrayList<Point> linePoints;
    private PrintCircleCanvas canvas;
    private PointCreator pointCreator = PointCreator.getInstance();
    private ArrayList<Point> ansPoints;

    private int stepNum = 0;
    private ArrayList<Point> stepPoints = new ArrayList<Point>();

    public NextStepListener(PrintCircleCanvas canvas) {
        this.canvas = canvas;
    }

    public void calculateConvexHull() {
        ConvexHullArithmetic convexHullArithmetic = new ConvexHullArithmetic(pointCreator.getPoints());
        ansPoints = convexHullArithmetic.getLinkLine();

        // reset step
        stepPoints.clear();
        stepNum = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(stepNum == 0) {
            stepPoints.add(ansPoints.get(stepNum));
            stepNum++;
        }
        stepPoints.add(ansPoints.get(stepNum));

        canvas.linkCircle(stepPoints);
        if (stepNum < ansPoints.size() - 1) {
            stepNum++;
        }

    }
}
