import ivisible.IVisible;
import figures.Figure;
import java.awt.*;

public class Button implements IVisible {
    static int point = 40;
    static int size = 25;
    static int scale = 4;

    int    idx;
    private Figure fig;

    Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        this.fig.x = scale+point;
        this.fig.y = scale+point + idx*size;
        this.fig.w = size-scale*2;
        this.fig.h = size-scale*2;
    }
    
    Button (int idx) {
        this.idx = idx;
    }

	public boolean clicked (int x, int y) {
        return point<=x && x<=point+size && point+this.idx*size<=y && y<=point+this.idx*size+size;
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
        g2d.fillRect(point, point+this.idx*size, size, size);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(point, point+this.idx*size, size, size);

        if (idx == 5) {
        	g2d.setColor(Color.BLACK);
        	g2d.fillRect(point+3, point+this.idx*size+10, size-5, size-20);
        	g2d.fillRect(point+11, point+this.idx*size+3, size-21, size-5);
        } else if (idx == 6) {
        	g2d.setColor(Color.BLACK);
        	g2d.fillRect(point+3, point+this.idx*size+10, size-5, size-20);
        } else if (idx == 9) {
        	g2d.setColor(Color.BLACK);
        	g2d.drawLine(point+3, point+this.idx*size+3, point+size-3, point+this.idx*size+size-3);
        	g2d.drawLine(point+3, point+this.idx*size+size-3, point+size-3, point+this.idx*size+3);
        }else {
        	this.fig.paint(g, false);
        }
    }
}