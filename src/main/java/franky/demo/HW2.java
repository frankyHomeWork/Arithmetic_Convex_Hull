package franky.demo;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.border.Border;
import java.awt.BorderLayout;

public class HW2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyCanvasDemo_1");
        //設定視窗顯示在螢幕在的位置
        frame.setLocation(100,100);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JButton button = new JButton("OK");
        frame.add(button, BorderLayout.SOUTH);

        TestCanvas a_canvas = new TestCanvas();
        frame.add(a_canvas, BorderLayout.CENTER);

        frame.setVisible(true);

    }
}