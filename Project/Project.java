import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.Rect;
import figures.Ellipse;
import figures.Arc;
import figures.Circle;
import figures.Figure;

class ListAppFigures {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    int a1 = rand.nextInt(180);
                    int a2 = rand.nextInt(180);
                    if (evt.getKeyChar() == 'r') {
                        Rect r = new Rect(x,y, w,h);
                        figs.add(r);
                    } else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h));
                    } else if (evt.getKeyChar() == 'a') {
                        figs.add(new Arc(x,y, w,h, a1,a2));
                    } else if (evt.getKeyChar() == 'c') {
                        figs.add(new Circle(x,y, w,w));
                    }
                    repaint();
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.Rect;
import figures.Ellipse;
import figures.Arc;
import figures.Circle;
import figures.Figure;

class ListAppFigures {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Figure focus = null;

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    int a1 = rand.nextInt(180);
                    int a2 = rand.nextInt(180);
                    int red = rand.nextInt(255);
                    int green = rand.nextInt(255);
                    int blue = rand.nextInt(255);
                    Color ccolor = new Color(red, green, blue);
                    Color bcolor = new Color(red, green, blue);
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x,y, w,h, ccolor,bcolor));
                    } else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h, ccolor,bcolor));
                    } else if (evt.getKeyChar() == 'a') {
                        figs.add(new Arc(x,y, w,h, a1,a2, ccolor,bcolor));
                    } else if (evt.getKeyChar() == 'c') {
                        figs.add(new Circle(x,y, w,w, ccolor,bcolor));
                    }
                    repaint();
                }
            }
        );

        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    int x = evt.getX();
                    int y = evt.getY();
                    for (Figure fig: figs) {
                        
                        }
                    }
                }
            }
        );

        this.setTitle("Lista de Figuras");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
    }
}
