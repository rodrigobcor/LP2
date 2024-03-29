package figures;

import java.awt.*;
import java.awt.geom.Arc2D;

public class Arc extends Figure {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Arc(int x, int y) {
		super(x, y);
	}

	public void paint(Graphics g, boolean focused) {
		Graphics2D g2d = (Graphics2D) g;

		if (focused) {
			g2d.setPaint(Color.RED);
			g2d.draw(new Arc2D.Double(this.x, this.y, this.w + 1, this.h + 1, this.a1, this.a2, Arc2D.PIE));
		}

		g2d.setColor(this.bcolor);
		g2d.fillArc(this.x, this.y, this.w, this.h, this.a1, this.a2);
	}

	public boolean clicked(int x, int y) {
		double dx = Math.abs(x - this.x - w / 2);
		double dy = Math.abs(y - this.y - h / 2);
		double d = dx / this.w + dy / this.h;
		return d <= 0.7;
	}

	public void resize(boolean more) {
		if (more == true) {
			this.x--;
			this.y--;
			this.w = this.w + 2;
			this.h = this.h + 2;
		} else {
			this.x++;
			this.y++;
			this.w = this.w - 2;
			this.h = this.h - 2;
		}
		if (this.w < 1) {
			this.w=1;
			this.x--;
		}
		if (this.h < 1) {
			this.h=1;
			this.y--;
		}
	}
}