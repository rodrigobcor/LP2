package figures;

import java.awt.*;
import java.awt.geom.Arc2D;

public class Arc extends Figure {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Arc(int x, int y, int w, int h, int a1, int a2, Color bcolor) {
		super(x, y, w, h, bcolor);
		this.a1 = a1;
		this.a2 = a2;
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
}
