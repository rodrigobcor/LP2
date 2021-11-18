package figures;

import java.awt.Color;
import java.io.Serializable;

import ivisible.IVisible;

public abstract class Figure implements IVisible, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x, y;
	int w = 30;
	int h = 30;
	int a1 = 30;
	int a2 = 240;
	static int red = 51;
	static int green = 51;
	static int blue = 51;
	Color bcolor = new Color(red, green, blue);

	Figure(int x, int y) {
		this.x = x - w / 2;
		this.y = y - h / 2;
	}

	public void drag(int dx, int dy) {
//		if (this.x < fx) {
//			this.x -= fx - this.x;
//		} else if (this.x > fx) {
//			this.x += this.x - fx;
//		}
//		if (this.y < fy) {
//			this.y -= fy - this.y;
//		} else if (this.y > fy) {
//			this.y += this.y - fy;
//		}
		this.x = dx;
		this.y = dy;
	}

	public abstract void resize(boolean more);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getA1() {
		return a1;
	}

	public void setA1(int a1) {
		this.a1 = a1;
	}

	public int getA2() {
		return a2;
	}

	public void setA2(int a2) {
		this.a2 = a2;
	}

	public static int getRed() {
		return red;
	}

	public static void setRed(int red) {
		Figure.red = red;
	}

	public static int getGreen() {
		return green;
	}

	public static void setGreen(int green) {
		Figure.green = green;
	}

	public static int getBlue() {
		return blue;
	}

	public static void setBlue(int blue) {
		Figure.blue = blue;
	}

	public Color getBcolor() {
		return bcolor;
	}

	public void setBcolor(Color bcolor) {
		this.bcolor = bcolor;
	}

}
