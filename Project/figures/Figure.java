package figures;

import java.awt.Color;
import java.io.Serializable;

import ivisible.IVisible;

public abstract class Figure implements IVisible, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x, y;
	public int w, h;
	public int a1, a2;
	public static int red = 51;
	public static int green = 51;
	public static int blue = 51;
	public Color bcolor;

	protected Figure(int x, int y, int w, int h) { 
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.bcolor = new Color(red, green, blue);;
	}

	public void drag(int dx, int dy) {
		this.x = dx;
		this.y = dy;
	}
}
