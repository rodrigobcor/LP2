import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(400, 400);
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Color verdeoliva = new Color (110,139,61);
        g2d.setColor(verdeoliva);
        int w = getWidth();
        int h = getHeight();
        g2d.drawString("Hello World!", 167, 217);
        CubicCurve2D a = new CubicCurve2D.Double();
        a.setCurve(50, 74, 150,
            44, 250, 104, 350, 74);
        g2d.draw(a);
        CubicCurve2D b = new CubicCurve2D.Double();
        b.setCurve(50, 74, 80,
            158, 30, 242, 50, 350);
        g2d.draw(b);
        CubicCurve2D c = new CubicCurve2D.Double();
        c.setCurve(50, 350, 150,
            320, 250, 370, 350, 350);
        g2d.draw(c);
        CubicCurve2D d = new CubicCurve2D.Double();
        d.setCurve(350, 74, 380,
            158, 320, 242, 350, 350);
        g2d.draw(d);
        g2d.draw(new Rectangle2D.Double(160, 203, 80, 20));
    }
}
