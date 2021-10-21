package figures;

import java.awt.*;
import ivisible.IVisible;

public abstract class Figure implements IVisible {
	public int x, y;
	public int w, h;
	public int a1, a2;
//	Color ccolor;
	Color bcolor;

	public Figure(int x, int y, int w, int h, Color bcolor) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
//		this.ccolor = ccolor;
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
