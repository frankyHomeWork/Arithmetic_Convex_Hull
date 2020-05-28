package franky.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateRandomPointListener implements ActionListener {

    private PointCreator pointCreator = PointCreator.getInstance();
    private TestCanvas canvas;
    private NextStepListener nextStepListener;

    public CreateRandomPointListener(TestCanvas canvas, NextStepListener nextStepListener) {
        this.canvas = canvas;
        this.nextStepListener = nextStepListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pointCreator.clearPoints();
        pointCreator.createRandomPoints(30, 300, 300);
        canvas.printCircle(pointCreator.getPoints());
        nextStepListener.calculateConvexHull();
    }

}
