package figures;

import java.awt.*;

public class Triangle extends Figure {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Triangle(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void paint(Graphics g, boolean focused) {
		Graphics2D g2d = (Graphics2D) g;
		
		if (focused) {
			int[] tx = { this.x + (this.w / 2), this.x + this.w + 1, this.x - 1 };
			int[] ty = { this.y - 1, this.y + this.h, this.y + this.h };
			g2d.setColor(Color.red);
			g2d.drawPolygon(tx, ty, 3);
		}
		
		int[] tx = { this.x + (this.w / 2), this.x + this.w, this.x };
		int[] ty = { this.y, this.y + this.h, this.y + this.h };
		g2d.setColor(this.bcolor);
		g2d.fillPolygon(tx, ty, 3);
	}
	
	public boolean clicked(int x, int y) {
		double triangleX1 = this.x + (this.y+this.h-y)/2;
		double triangleX2 = this.x + this.w - (this.y+this.h-y)/2;
		return (triangleX1 <= x && x <= triangleX2 && this.y <= y && y <= this.y + this.h);
	}
}