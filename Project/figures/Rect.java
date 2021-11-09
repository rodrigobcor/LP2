package figures;

import java.awt.*;

public class Rect extends Figure {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Rect(int x, int y, int w, int h, Color bcolor) {
		super(x, y, w, h, bcolor);
	}

	public void paint(Graphics g, boolean focused) {
		Graphics2D g2d = (Graphics2D) g;
		
		if (focused) {
			g2d.setColor(Color.red);
			g2d.drawRect(this.x - 1, this.y - 1, this.w + 1, this.h + 1);
		}
		
		g2d.setColor(this.bcolor);
		g2d.fillRect(this.x, this.y, this.w, this.h);
	}
	
	public boolean clicked(int x, int y) {
		return (this.x <= x && x <= this.x + this.w && this.y <= y && y <= this.y + this.h);
	}
}
