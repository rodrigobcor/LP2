import ivisible.IVisible;
import figures.Figure;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Button implements IVisible {
    static int point = 40;
    static int size = 25;
    static int scale = 4;

    int    idx;
    public Figure fig;

    Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        this.fig.x = scale+point;
        this.fig.y = scale+point + idx*size;
        this.fig.w = size-scale*2;
        this.fig.h = size-scale*2;
        this.fig.bcolor = Color.black;
    }
    
    Button (int idx) {
        this.idx = idx;
    }

	public boolean clicked (int x, int y) {
		if (idx == 41) {
			return point-size<=x && x<=point && point+4*size<=y && y<=point+4*size+size;
		} else if (idx == 42) {
			return point+size<=x && x<=point+size*2 && point+4*size<=y && y<=point+4*size+size;
		} else {
			return point<=x && x<=point+size && point+this.idx*size<=y && y<=point+this.idx*size+size;
		}
	}

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

	    if (idx == 41) {
        	g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
	        g2d.fillRect(point-size, point+4*size, size, size);
	
	        g2d.setColor(Color.BLACK);
	        g2d.drawRect(point-size, point+4*size, size, size);
        } else if (idx == 42) {
        	g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
	        g2d.fillRect(point+size, point+4*size, size, size);
	
	        g2d.setColor(Color.BLACK);
	        g2d.drawRect(point+size, point+4*size, size, size);
        } else {
	        g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
	        g2d.fillRect(point, point+this.idx*size, size, size);
	
	        g2d.setColor(Color.BLACK);
	        g2d.drawRect(point, point+this.idx*size, size, size);
        }

        if (idx == 4) {
        	g2d.setColor(new Color(0, Figure.green, 0));
        	g2d.fill(new Ellipse2D.Double(scale+point, scale+point + idx*size, size-scale*2, size-scale*2));
        	g2d.setColor(Color.BLACK);
        	g2d.drawString(String.valueOf(Figure.green/51)+"/5", scale+point, scale+point + 4*size+35);
        } else if (idx == 41) {
        	g2d.setColor(new Color(Figure.red, 0, 0));
        	g2d.fill(new Ellipse2D.Double(scale+point-size, scale+point + 4*size, size-scale*2, size-scale*2));
        	g2d.setColor(Color.BLACK);
        	g2d.drawString(String.valueOf(Figure.red/51)+"/5", scale+point-size, scale+point + 4*size+35);
        } else if (idx == 42) {
        	g2d.setColor(new Color(0, 0, Figure.blue));
        	g2d.fill(new Ellipse2D.Double(scale+point+size, scale+point + 4*size, size-scale*2, size-scale*2));
        	g2d.setColor(Color.BLACK);
        	g2d.drawString(String.valueOf(Figure.blue/51)+"/5", scale+point+size, scale+point + 4*size+35);
    	} else if (idx == 6) {
        	g2d.setColor(Color.BLACK);
        	g2d.fillRect(point+3, point+this.idx*size+10, size-5, size-20);
        	g2d.fillRect(point+11, point+this.idx*size+3, size-21, size-5);
        } else if (idx == 7) {
        	g2d.setColor(Color.BLACK);
        	g2d.fillRect(point+3, point+this.idx*size+10, size-5, size-20);
        } else if (idx == 9) {
        	g2d.setColor(Color.BLACK);
        	g2d.drawLine(point+3, point+this.idx*size+3, point+size-3, point+this.idx*size+size-3);
        	g2d.drawLine(point+3, point+this.idx*size+size-3, point+size-3, point+this.idx*size+3);
        } else if (idx == 10) {
        	fig=null;
        } else {
        	fig.bcolor = new Color(Figure.red, Figure.green, Figure.blue);
        	this.fig.paint(g, false);
        }
    }
}