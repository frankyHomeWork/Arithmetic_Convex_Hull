package franky.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateRandomPointListener implements ActionListener {

    private PointCreator pointCreator = PointCreator.getInstance();
    private PrintCircleCanvas canvas;
    private NextStepListener nextStepListener;

    private int points_num = 30;
    private int points_range_start = 20;
    private int points_range_end = 400;

    public CreateRandomPointListener(PrintCircleCanvas canvas, NextStepListener nextStepListener) {
        this.canvas = canvas;
        this.nextStepListener = nextStepListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pointCreator.clearPoints();
        pointCreator.createRandomPoints(points_num, points_range_start, points_range_end);
        canvas.setPoints(pointCreator.getPoints());
        canvas.print(canvas.getGraphics());
        nextStepListener.calculateConvexHull();
    }

    public void setPoints_num(int points_num) {
        this.points_num = points_num;
    }

    public void setPoints_range_start(int points_range_start) {
        this.points_range_start = points_range_start;
    }

    public void setPoints_range_end(int points_range_end) {
        this.points_range_end = points_range_end;
    }
}
