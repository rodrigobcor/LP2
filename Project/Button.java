import ivisible.IVisible;
import figures.Figure;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Button implements IVisible {
	private static int point = 40;
	private static int size = 25;
	private static int scale = 4;

	public int getIdx() {
		return idx;
	}

	public Figure getFig() {
		return fig;
	}

	private int idx;
	private Figure fig;

	Button(int idx, Figure fig) {
		this.idx = idx;
		this.fig = fig;
		fig.setX(scale + point);
		fig.setY(scale + point + idx * size);
		fig.setW(size - scale * 2);
		fig.setH(size - scale * 2);
	}

	Button(int idx) {
		this.idx = idx;
	}

	public boolean clicked(int x, int y) {
		if (idx == 41) {
			return point - size <= x && x <= point && point + 4 * size <= y && y <= point + 4 * size + size;
		} else if (idx == 42) {
			return point + size <= x && x <= point + size * 2 && point + 4 * size <= y && y <= point + 4 * size + size;
		} else {
			return point <= x && x <= point + size && point + this.idx * size <= y
					&& y <= point + this.idx * size + size;
		}
	}

	public void paint(Graphics g, boolean focused) {
		Graphics2D g2d = (Graphics2D) g;

		if (idx == 41) {
			g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
			g2d.fillRect(point - size, point + 4 * size, size, size);

			g2d.setColor(Color.BLACK);
			g2d.drawRect(point - size, point + 4 * size, size, size);
		} else if (idx == 42) {
			g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
			g2d.fillRect(point + size, point + 4 * size, size, size);

			g2d.setColor(Color.BLACK);
			g2d.drawRect(point + size, point + 4 * size, size, size);
		} else {
			g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
			g2d.fillRect(point, point + this.idx * size, size, size);

			g2d.setColor(Color.BLACK);
			g2d.drawRect(point, point + this.idx * size, size, size);
		}

		if (idx == 4) {
			g2d.setColor(new Color(0, Figure.getGreen(), 0));
			g2d.fill(new Ellipse2D.Double(scale + point, scale + point + idx * size, size - scale * 2,
					size - scale * 2));
			g2d.setColor(Color.BLACK);
			g2d.drawString(String.valueOf(Figure.getGreen() / 51) + "/5", scale + point, scale + point + 4 * size + 35);
		} else if (idx == 41) {
			g2d.setColor(new Color(Figure.getRed(), 0, 0));
			g2d.fill(new Ellipse2D.Double(scale + point - size, scale + point + 4 * size, size - scale * 2,
					size - scale * 2));
			g2d.setColor(Color.BLACK);
			g2d.drawString(String.valueOf(Figure.getRed() / 51) + "/5", scale + point - size,
					scale + point + 4 * size + 35);
		} else if (idx == 42) {
			g2d.setColor(new Color(0, 0, Figure.getBlue()));
			g2d.fill(new Ellipse2D.Double(scale + point + size, scale + point + 4 * size, size - scale * 2,
					size - scale * 2));
			g2d.setColor(Color.BLACK);
			g2d.drawString(String.valueOf(Figure.getBlue() / 51) + "/5", scale + point + size,
					scale + point + 4 * size + 35);
		} else if (idx == 6) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(point + 3, point + this.idx * size + 10, size - 5, size - 20);
			g2d.fillRect(point + 11, point + this.idx * size + 3, size - 21, size - 5);
		} else if (idx == 7) {
			g2d.setColor(Color.BLACK);
			g2d.fillRect(point + 3, point + this.idx * size + 10, size - 5, size - 20);
		} else if (idx == 9) {
			g2d.setColor(Color.BLACK);
			g2d.drawLine(point + 3, point + this.idx * size + 3, point + size - 3, point + this.idx * size + size - 3);
			g2d.drawLine(point + 3, point + this.idx * size + size - 3, point + size - 3, point + this.idx * size + 3);
		} else if (idx == 10) {
			fig = null;
		} else {
			fig.setBcolor(new Color(Figure.getRed(), Figure.getGreen(), Figure.getBlue()));
			this.fig.paint(g, false);
		}
	}
}