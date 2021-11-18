import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;

import figures.Arc;
import figures.Ellipse;
import figures.Figure;
import figures.Rect;
import figures.Triangle;

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

		buts.add(new Button(0, new Rect(0, 0)));
		buts.add(new Button(1, new Ellipse(0, 0)));
		buts.add(new Button(2, new Arc(0, 0)));
		buts.add(new Button(3, new Triangle(0, 0)));
		buts.add(new Button(4));
		buts.add(new Button(41));
		buts.add(new Button(42));
		buts.add(new Button(6));
		buts.add(new Button(7));
		buts.add(new Button(9));
		buts.add(new Button(10));

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				mx = MouseInfo.getPointerInfo().getLocation().x;
				my = MouseInfo.getPointerInfo().getLocation().y;
				if (evt.getKeyChar() == 'r') {
					Rect r = new Rect(mx, my);
					focus = r;
					figs.add(r);
				} else if (evt.getKeyChar() == 'e') {
					Ellipse e = new Ellipse(mx, my);
					focus = e;
					figs.add(e);
				} else if (evt.getKeyChar() == 'a') {
					Arc a = new Arc(mx, my);
					focus = a;
					figs.add(a);
				} else if (evt.getKeyChar() == 't') {
					Triangle t = new Triangle(mx, my);
					focus = t;
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
						break;
					case KeyEvent.VK_UP:
						focus.setY(focus.getY() - 1);
						break;
					case KeyEvent.VK_DOWN:
						focus.setY(focus.getY() + 1);
						break;
					case KeyEvent.VK_LEFT:
						focus.setX(focus.getX() - 1);
						break;
					case KeyEvent.VK_RIGHT:
						focus.setX(focus.getX() + 1);
						break;
					case KeyEvent.VK_ADD:
						focus.resize(true);
						break;
					case KeyEvent.VK_SUBTRACT:
						focus.resize(false);
						break;
					case KeyEvent.VK_ESCAPE:
						System.exit(0);
						break;
					}
				}
				repaint();
			}
		});

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				mx = evt.getX();
				my = evt.getY();
				if (focus_but != null) {
					if (focus_but.getIdx() == 0) {
						Rect r = new Rect(mx, my);
						figs.add(r);
						focus = r;
						focus_but = null;
					} else if (focus_but.getIdx() == 1) {
						Ellipse e = new Ellipse(mx, my);
						figs.add(e);
						focus = e;
						focus_but = null;
					} else if (focus_but.getIdx() == 2) {
						Arc a = new Arc(mx, my);
						figs.add(a);
						focus = a;
						focus_but = null;
					} else if (focus_but.getIdx() == 3) {
						Triangle t = new Triangle(mx, my);
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
							if (focus_but.getIdx() == 4) {
								Figure.setGreen(Figure.getGreen() + 51);
								if (Figure.getGreen() > 255) {
									Figure.setGreen(51);
								}
								focus_but = null;
							} else if (focus_but.getIdx() == 41) {
								Figure.setRed(Figure.getRed() + 51);
								if (Figure.getRed() > 255) {
									Figure.setRed(51);
								}
								focus_but = null;
							} else if (focus_but.getIdx() == 42) {
								Figure.setBlue(Figure.getBlue() + 51);
								if (Figure.getBlue() > 255) {
									Figure.setBlue(51);
								}
								focus_but = null;
							} else if (focus_but.getIdx() == 6) {
								if (focus != null) {
									focus.resize(true);
								}
								focus_but = null;
							} else if (focus_but.getIdx() == 7) {
								if (focus != null) {
									focus.resize(false);
								}
								focus_but = null;
							} else if (focus_but.getIdx() == 9) {
								if (focus != null) {
									figs.remove(focus);
									focus = null;
								}
								focus_but = null;
							} else if (focus_but.getIdx() == 10) {
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
				mx = evt.getX();
				my = evt.getY();
				if (focus != null && focus.clicked(mx, my) == true) {
					int dx = evt.getX() - (focus.getW() / 2);
					int dy = evt.getY() - (focus.getH() / 2);
					focus.drag(dx, dy);
					repaint();
				}
			}
		});

		this.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent evt) {
				if (focus != null) {
					if (evt.getWheelRotation() < 0) {
						if (focus.getA1() != 0 && evt.getModifiersEx() == 128) {
							focus.setA1(focus.getA1() - 1);
							focus.setA2(focus.getA2() + 2);
						} else {
							focus.resize(true);
						}
					} else {
						if (focus.getA1() != 0 && evt.getModifiersEx() == 128) {
							focus.setA1(focus.getA1() + 1);
							focus.setA2(focus.getA2() - 2);
						} else {
							focus.resize(false);
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
