package franky.demo;

import java.awt.*;

public class TestCanvas extends Canvas {
    public TestCanvas() {
        setSize(500,500);
    }
    public void paint(Graphics g) {
        //畫一條直線,從座標(100,100)到(150,150)
        System.out.println("in paint");
        g.drawLine(0,0,15,15);
    }
    public void update(Graphics g) {
        System.out.println("in Update");
    }
}




