import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectApp {
	public static void main (String[] args) {
		Rect r1 = new Rect(1,1,10,10);
		r1.print();
		r1.area();
		r1.drag(5,5);
	}
}

class Rect {
	int x, y;
	int w, h;
	int a;
	Rect (int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.a = x*y;
	}
	void print () {
		System.out.format("Um cubo com largura %d e altura %d, iniciado em (%d,%d)\n",
			this.w, this.h, this.x, this.y);
	}
	int area () {
		System.out.format("A area e %d\n", this.a);
		return a;
	}
	void drag (int dx, int dy) {
		this.x=x+dx;
		this.y=y+dy;
	}
}
