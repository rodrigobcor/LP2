package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Figure {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ellipse(int x, int y) {
		super(x, y);
	}

	public void paint(Graphics g, boolean focused) {
		Graphics2D g2d = (Graphics2D) g;

		if (focused) {
			g2d.setColor(Color.red);
			g2d.draw(new Ellipse2D.Double(this.x - 2, this.y + 1, this.w + 3, this.h - 3));
		}

		g2d.setColor(this.bcolor);
		g2d.fill(new Ellipse2D.Double(this.x - 1, this.y + 2, this.w + 2, this.h - 4));
	}

	public boolean clicked(int x, int y) {
		double dx = Math.abs(x - this.x - w / 2);
		double dy = Math.abs(y - this.y - h / 2);
		double d = dx / this.w + dy / this.h;
		return d <= 0.5;
	}

	public void resize(boolean more) {
		if (more == true) {
			this.x = this.x - 2;
			this.y--;
			this.w = this.w + 3;
			this.h = this.h + 2;
		} else {
			this.x = this.x + 2;
			this.y++;
			this.w = this.w - 3;
			this.h = this.h - 2;
		}
		if (this.w < 1) {
			this.w=2;
			this.x -= 2;
		}
		if (this.h < 1) {
			this.h=1;
			this.y--;
		}
	}
}