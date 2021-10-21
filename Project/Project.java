import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import figures.Rect;
import figures.Ellipse;
import figures.Arc;
import figures.Triangle;
import figures.Figure;
import figures.Foco;

class Project {
	public static void main(String[] args) {
		ListFrame frame = new ListFrame();
		frame.setVisible(true);
	}
}

class ListFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Figure> figs = new ArrayList<Figure>();
	Random rand = new Random();
	Figure focus = null;
	Foco f1;
	int mx, my;

	ListFrame() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				int w = rand.nextInt(50);
				int h = rand.nextInt(50);
				int x = MouseInfo.getPointerInfo().getLocation().x - (w / 2);
				int y = MouseInfo.getPointerInfo().getLocation().y - (h / 2);
				int a1 = rand.nextInt(180);
				int a2 = rand.nextInt(180);
				int red = rand.nextInt(255);
				int green = rand.nextInt(255);
				int blue = rand.nextInt(255);
				Color ccolor = new Color(red, green, blue);
				Color bcolor = new Color(red, green, blue);
				if (evt.getKeyChar() == 'r') {
					Rect r = new Rect(x, y, w, h, ccolor, bcolor);
					figs.add(r);
				} else if (evt.getKeyChar() == 'e') {
					Ellipse e = new Ellipse(x, y, w, h, ccolor, bcolor);
					figs.add(e);
				} else if (evt.getKeyChar() == 'a') {
					Arc a = new Arc(x, y, w, w, a1, a2, ccolor, bcolor);
					figs.add(a);
				} else if (evt.getKeyChar() == 't') {
					Triangle t = new Triangle(x, y, w, h, ccolor, bcolor);
					figs.add(t);
				}
				int keyCode = evt.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_DELETE:
					figs.remove(focus);
					focus = null;
					repaint();
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
				case KeyEvent.VK_RIGHT:
					focus.x++;
					break;
				case KeyEvent.VK_ADD:
					focus.x--;
					focus.y--;
					focus.w = focus.w + 2;
					focus.h = focus.h + 2;
					break;
				case KeyEvent.VK_SUBTRACT:
					focus.x++;
					focus.y++;
					focus.w = focus.w - 2;
					focus.h = focus.h - 2;
					break;
				}
				for (Figure fig : figs) {
					focus = fig;
				}
				repaint();
			}
		});

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				int mx = evt.getX();
				int my = evt.getY();
				int n = figs.size();
				int i = 0;
				for (Figure fig : figs) {
					if (fig.clicked(mx, my)) {
						focus = fig;
						figs.set(i, figs.get(n - 1));
						figs.set(n - 1, focus);
					}
					i++;
				}
				repaint();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				int dx = evt.getX() - (focus.w / 2);
				int dy = evt.getY() - (focus.h / 2);
				focus.drag(dx, dy);
				repaint();
			}
		});

		this.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent evt) {
				int w = evt.getWheelRotation();
				if (w < 0) {
					focus.x--;
					focus.y--;
					focus.w = focus.w + 2;
					focus.h = focus.h + 2;
				} else {
					focus.x++;
					focus.y++;
					focus.w = focus.w - 2;
					focus.h = focus.h - 2;
				}
				repaint();
			}
		});

		this.setTitle("Lista de Figuras");
		this.setSize(350, 350);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (Figure fig : this.figs) {
			fig.paint(g);
		}
		if (focus != null) {
			Foco f1 = new Foco(focus.x - 1, focus.y - 1, focus.w + 2, focus.h + 2, Color.RED);
			f1.paint(g);
		}
	}
}
