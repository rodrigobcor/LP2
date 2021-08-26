import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1;
    Rect r2;
    Rect r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30, Color.black, Color.blue);
        this.r2 = new Rect(50,150, 100,30, Color.black, Color.red);
        this.r3 = new Rect(50,250, 100,30, Color.black, Color.green);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
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
        g2d.drawRect(this.x,this.y, this.w,this.h);
	g2d.setColor(this.bcolor);
        g2d.fillRect(this.x+1,this.y+1, this.w-1,this.h-1);

    }
}
