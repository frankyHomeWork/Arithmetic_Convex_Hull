package franky.demo;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HW2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyCanvasDemo_1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());


        JButton resetButton = new JButton("Reset");
        frame.add(resetButton, BorderLayout.NORTH);

        JButton linkLineButton = new JButton("next Step");
        frame.add(linkLineButton, BorderLayout.SOUTH);

        final TestCanvas a_canvas = new TestCanvas();
        frame.add(a_canvas, BorderLayout.CENTER);

        NextStepListener nextStepListener = new NextStepListener(a_canvas);
        CreateRandomPointListener createRandomPointListener = new CreateRandomPointListener(a_canvas, nextStepListener);

        createRandomPointListener.setPoints_num(20);
        createRandomPointListener.setPoints_range_start(50);
        createRandomPointListener.setPoints_range_end(400);

        resetButton.addActionListener(createRandomPointListener);

        linkLineButton.addActionListener(nextStepListener);

        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
}