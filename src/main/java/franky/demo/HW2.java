package franky.demo;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;

public class HW2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyCanvasDemo_1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());


        JButton resetButton = new JButton("Reset");
        frame.add(resetButton, BorderLayout.NORTH);

        JButton linkLineButton = new JButton("next Step");
        frame.add(linkLineButton, BorderLayout.SOUTH);

        final PrintCircleCanvas printCircleCanvas = new PrintCircleCanvas();
        frame.add(printCircleCanvas, BorderLayout.CENTER);

        NextStepListener nextStepListener = new NextStepListener(printCircleCanvas);
        CreateRandomPointListener createRandomPointListener = new CreateRandomPointListener(printCircleCanvas, nextStepListener);

        createRandomPointListener.setPoints_num(25);
        createRandomPointListener.setPoints_range_start(100);
        createRandomPointListener.setPoints_range_end(700);

        resetButton.addActionListener(createRandomPointListener);

        linkLineButton.addActionListener(nextStepListener);

        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
}