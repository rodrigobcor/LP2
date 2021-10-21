package figures;

import java.awt.*;

public class Rect extends Figure {
	public Rect(int x, int y, int w, int h, Color bcolor) {
		super(x, y, w, h, bcolor);
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(this.bcolor);
		g2d.fillRect(this.x, this.y, this.w, this.h);
	}

	public void foco(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		g2d.drawRect(this.x - 1, this.y - 1, this.w + 1, this.h + 1);
	}
}
