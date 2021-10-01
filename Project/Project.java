import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import figures.Rect;
import figures.Ellipse;
import figures.Arc;
import figures.Circle;
import figures.Figure;
import figures.Foco;

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
    Foco fc1;
    int mx,my;

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
                    } int keyCode = evt.getKeyCode();
                        switch(keyCode) { 
                            case KeyEvent.VK_DELETE:
                                for (Figure fig: figs) {
                                    if (fig==focus){
                                        figs.remove(fig);
                                    }
                                }
                                break;
                            case KeyEvent.VK_UP:
                                focus.y--;
                                break;
                            case KeyEvent.VK_DOWN:
                                focus.y++;
                                break;
                            case KeyEvent.VK_LEFT:
                                focus.x--;
                                break;
                            case KeyEvent.VK_RIGHT :
                                focus.x++;
                                break;
                            case KeyEvent.VK_ADD:
                                focus.x--;
                                focus.y--;
                                focus.w++;
                                focus.h++;
                                break;
                            case KeyEvent.VK_SUBTRACT:
                                focus.x++;
                                focus.y++;
                                focus.w--;
                                focus.h--;
                                break;
                        }
                    for (Figure fig: figs) {
                        focus=fig;
                    }
                    repaint();
                }
            }
        );

        this.addMouseListener (
            new MouseAdapter() {
                public void mousePressed (MouseEvent evt) {
                    int mx = evt.getX();
                    int my = evt.getY();
                    for (Figure fig: figs) {
                        if (fig.clicked(mx,my)) {
                            focus=fig;
                            figs.add(fig);
                            figs.remove(fig);
                            repaint();
                            System.out.println("CLICKED");
                            System.out.println(focus);
                        }
                    }
                }
            }
        );

        this.addMouseMotionListener (
            new MouseMotionAdapter() {
                public void mouseDragged (MouseEvent evt) {
                    int dx = evt.getX() - mx;
                    int dy = evt.getY() - my;
                    focus.drag(dx,dy);
                    repaint();
                }
            }
        );

        this.addMouseWheelListener (
            new MouseWheelListener() {
                public void mouseWheelMoved (MouseWheelEvent evt) {
                    int w = evt.getWheelRotation();
                    if (w < 0) {
                        focus.x--;
                        focus.y--;
                        focus.w++;
                        focus.h++;
                        System.out.println("wheel up");
                    } else {
                        focus.x++;
                        focus.y++;
                        focus.w--;
                        focus.h--;
                        System.out.println("wheel down");
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
            if (fig==focus){
                int x = fig.x-1;
                int y = fig.y-1;
                int w = fig.w+1;
                int h = fig.h+1;
                Color ccolor = Color.RED;
                this.fc1 = new Foco(x,y,w,h,ccolor);
                this.fc1.paint(g);
            }
        }
        System.out.println(focus);
    }
}
