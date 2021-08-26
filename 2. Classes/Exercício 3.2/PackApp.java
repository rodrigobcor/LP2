import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figures.Rect;
import figures.Ellipse;
import figures.Circle;
import figures.Arc;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Circle c1;
    Arc a1;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50,100,30, Color.black, new Color(90,160,57));
        this.e1 = new Ellipse(50,100,100,30, Color.yellow, new Color(101,53,31));
        this.c1 = new Circle(50,150,100,100, Color.blue, new Color(65,131,152));
        this.a1 = new Arc(50,275,110,100,5,150, Color.pink, new Color(209,177,189));
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.c1.paint(g);
        this.a1.paint(g);
    }
}
