import java.awt.*;
import java.io.*;
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
	ArrayList<Button> buts = new ArrayList<Button>();
	Random rand = new Random();
	Figure focus = null;
	Button focus_but = null;
	int mx, my;

	ListFrame() {

		try {
			FileInputStream f = new FileInputStream("proj.bin");
			ObjectInputStream o = new ObjectInputStream(f);
			this.figs = (ArrayList<Figure>) o.readObject();
			o.close();
		} catch (Exception x) {
			System.out.println("ERRO!");
		}

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					FileOutputStream f = new FileOutputStream("proj.bin");
					ObjectOutputStream o = new ObjectOutputStream(f);
					o.writeObject(figs);
					o.flush();
					o.close();
				} catch (Exception x) {
				}
				System.exit(0);
			}
		});

		buts.add(new Button(0, new Rect(0, 0, 0, 0, null)));
		buts.add(new Button(1, new Ellipse(0, 0, 0, 0, null)));
		buts.add(new Button(2, new Arc(0, 0, 0, 0, 30, 240, null)));
		buts.add(new Button(3, new Triangle(0, 0, 0, 0, null)));
		buts.add(new Button(5));
		buts.add(new Button(6));
		buts.add(new Button(9));
		buts.add(new Button(10, new Rect(0, 0, 0, 0, Color.LIGHT_GRAY)));
		repaint();

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				int w = 30;
				int h = 30;
				int x = MouseInfo.getPointerInfo().getLocation().x - (w / 2);
				int y = MouseInfo.getPointerInfo().getLocation().y - (h / 2);
				int a1 = 30;
				int a2 = 240;
				int red = rand.nextInt(255);
				int green = rand.nextInt(255);
				int blue = rand.nextInt(255);
				Color bcolor = new Color(red, green, blue);
				if (evt.getKeyChar() == 'r') {
					Rect r = new Rect(x, y, w, h, bcolor);
					figs.add(r);
				} else if (evt.getKeyChar() == 'e') {
					Ellipse e = new Ellipse(x, y, w + 15, h, bcolor);
					figs.add(e);
				} else if (evt.getKeyChar() == 'a') {
					Arc a = new Arc(x, y, w, w, a1, a2, bcolor);
					figs.add(a);
				} else if (evt.getKeyChar() == 't') {
					Triangle t = new Triangle(x, y, w, h, bcolor);
					figs.add(t);
				} else if (evt.getKeyChar() == 'c') {
					focus = null;
					figs.clear();
				}
				if (focus != null) {
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
					case KeyEvent.VK_ESCAPE:
						System.exit(0);
						break;
					}
				}
				for (Figure fig : figs) {
					focus = fig;
				}
				repaint();
			}
		});

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				mx = evt.getX();
				my = evt.getY();
				int w = 30;
				int h = 30;
				int a1 = 30;
				int a2 = 240;
				int red = rand.nextInt(255);
				int green = rand.nextInt(255);
				int blue = rand.nextInt(255);
				Color bcolor = new Color(red, green, blue);
				if (focus_but != null) {
					if (focus_but.idx == 0) {
						Rect r = new Rect(mx - w / 2, my - h / 2, w, h, bcolor);
						figs.add(r);
						focus = r;
						focus_but = null;
					} else if (focus_but.idx == 1) {
						Ellipse e = new Ellipse(mx - w / 2, my - h / 2, w + 15, h, bcolor);
						figs.add(e);
						focus = e;
						focus_but = null;
					} else if (focus_but.idx == 2) {
						Arc a = new Arc(mx - w / 2, my - h / 2, w, w, a1, a2, bcolor);
						figs.add(a);
						focus = a;
						focus_but = null;
					} else if (focus_but.idx == 3) {
						Triangle t = new Triangle(mx - w / 2, my - h / 2, w, h, bcolor);
						figs.add(t);
						focus = t;
						focus_but = null;
					}
				} else {
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
					for (Button but : buts) {
						if (but.clicked(mx, my)) {
							focus_but = but;
							if (focus_but.idx == 5) {
								focus.x--;
								focus.y--;
								focus.w = focus.w + 2;
								focus.h = focus.h + 2;
								focus_but = null;
							} else if (focus_but.idx == 6) {
								focus.x++;
								focus.y++;
								focus.w = focus.w - 2;
								focus.h = focus.h - 2;
								focus_but = null;
							} else if (focus_but.idx == 9) {
								figs.remove(focus);
								focus = null;
								repaint();
								focus_but = null;
							}else if (focus_but.idx == 10) {
								focus = null;
								figs.clear();
								focus_but = null;
							}
						}
					}
				}
				repaint();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				if (focus != null) {
					int dx = evt.getX() - (focus.w / 2);
					int dy = evt.getY() - (focus.h / 2);
					focus.drag(dx, dy);
					repaint();
				}
			}
		});

		this.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent evt) {
				if (focus != null) {
					if (evt.getWheelRotation() < 0) {
						if (focus.a1 != 0 && evt.getModifiersEx() == 128) {
							focus.a1--;
							focus.a2 = focus.a2 + 2;
						} else {
							focus.x--;
							focus.y--;
							focus.w = focus.w + 2;
							focus.h = focus.h + 2;
						}
					} else {
						if (focus.a1 != 0 && evt.getModifiersEx() == 128) {
							focus.a1++;
							focus.a2 = focus.a2 - 2;
						} else {
							focus.x++;
							focus.y++;
							focus.w = focus.w - 2;
							focus.h = focus.h - 2;
						}
					}
					repaint();
				}
			}
		});

		this.setTitle("Lista de Figuras");
		this.setSize(350, 350);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (Button but : this.buts) {
			but.paint(g, but == focus_but);
		}
		for (Figure fig : this.figs) {
			fig.paint(g, fig == focus);
		}
	}
}
