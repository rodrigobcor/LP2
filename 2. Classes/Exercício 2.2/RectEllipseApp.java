import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Ellipse e2;
    Ellipse e3;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30, Color.black, Color.blue);
        this.e1 = new Ellipse(200,50, 100,30, Color.red, new Color(250,50,250));
        this.e2 = new Ellipse(200,150, 100,30, Color.red, new Color(150,150,150));
        this.e3 = new Ellipse(200,250, 100,30, Color.red, new Color(50,250,50));
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Rect {
    	int x, y;
	int w, h;
	Color ccolor;
	Color bcolor;

    Rect (int x, int y, int w, int h, Color ccolor, Color bcolor) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.ccolor = ccolor;
	this.bcolor = bcolor;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.ccolor);
        g.drawRect(this.x,this.y, this.w,this.h);
	g2d.setColor(this.bcolor);
        g2d.fillRect(this.x+1,this.y+1, this.w-1,this.h-1);
    }
}

class Ellipse {
	int x, y;
	int w, h;
	Color ccolor;
	Color bcolor;

    Ellipse (int x, int y, int w, int h, Color ccolor, Color bcolor) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.ccolor = ccolor;
	this.bcolor = bcolor;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(this.ccolor);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
	g2d.setColor(this.bcolor);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}
