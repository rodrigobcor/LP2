package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ellipse extends Figure {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ellipse(int x, int y, int w, int h, Color bcolor) {
		super(x, y, w, h, bcolor);
	}

	public void paint(Graphics g, boolean focused) {
		Graphics2D g2d = (Graphics2D) g;
		
		if (focused) {
			g2d.setColor(Color.red);
			g2d.draw(new Ellipse2D.Double(this.x - 1, this.y - 1, this.w + 1, this.h + 1));
		}
		
		g2d.setColor(this.bcolor);
		g2d.fill(new Ellipse2D.Double(this.x, this.y, this.w, this.h));
	}
}
