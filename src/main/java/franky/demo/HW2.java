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

        JButton linkLineButton = new JButton("next Step");
        frame.add(linkLineButton, BorderLayout.SOUTH);

        JButton resetButton = new JButton("Reset");
        frame.add(resetButton, BorderLayout.NORTH);

        final TestCanvas a_canvas = new TestCanvas();
        frame.add(a_canvas, BorderLayout.CENTER);

        final PointCreator pointCreator = PointCreator.getInstance();


        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
//                a_canvas.printCircle(10);
                pointCreator.clearPoints();
                pointCreator.createRandomPoints(30, 300, 300);
                a_canvas.printCircle(pointCreator.getPoints());
            }
        });

        linkLineButton.addActionListener(new ActionListener() {
            ArrayList<Point> newLine = new ArrayList<Point>();
            int ans_count = 0;
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ConvexHullArithmetic convexHullArithmetic = new ConvexHullArithmetic(pointCreator.getPoints());
                ArrayList<Point> ans =  convexHullArithmetic.getLinkLine();

                newLine.add(ans.get(ans_count));

                if(ans_count < ans.size() - 1) {
                    ans_count++;
                }

                a_canvas.linkCircle(newLine);
            }
        });



        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
}