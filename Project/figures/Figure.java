package figures;

import java.awt.*;
import ivisible.IVisible;
import java.io.Serializable;

public abstract class Figure implements IVisible, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x, y;
	public int w, h;
	public int a1, a2;
	Color bcolor;

	protected Figure(int x, int y, int w, int h, Color bcolor) { 
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.bcolor = bcolor;
	}

	public void drag(int dx, int dy) {
		this.x = dx;
		this.y = dy;
	}

	public boolean clicked(int x, int y) {
		return (this.x <= x && x <= this.x + this.w && this.y <= y && y <= this.y + this.h);
	} 
}
