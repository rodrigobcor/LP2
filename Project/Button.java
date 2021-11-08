import ivisible.IVisible;
import figures.Figure;
import java.awt.*;

public class Button implements IVisible {
    static int SPC = 40;
    static int DIM = 25;
    static int PAD = 4;

    int    idx;
    private Figure fig;

    Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        this.fig.x = PAD+SPC;
        this.fig.y = PAD+SPC + idx*DIM;
        this.fig.w = DIM-PAD*2;
        this.fig.h = DIM-PAD*2;
    }
    
    Button (int idx) {
        this.idx = idx;
    }

	public boolean clicked (int x, int y) {
        return SPC<=x && x<=SPC+DIM && SPC+this.idx*DIM<=y && y<=SPC+this.idx*DIM+DIM;
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
        g2d.fillRect(SPC, SPC+this.idx*DIM, DIM, DIM);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(SPC, SPC+this.idx*DIM, DIM, DIM);

        if (idx == 7) {
        	g2d.setColor(Color.BLACK);
        	g2d.fillRect(SPC+3, SPC+this.idx*DIM+10, DIM-5, DIM-20);
        	g2d.fillRect(SPC+11, SPC+this.idx*DIM+3, DIM-21, DIM-5);
        } else if (idx == 8) {
        	g2d.setColor(Color.BLACK);
        	g2d.fillRect(SPC+3, SPC+this.idx*DIM+10, DIM-5, DIM-20);
        } else if (idx == 10) {
        	g2d.setColor(Color.BLACK);
        	g2d.drawLine(SPC, SPC+this.idx*DIM, SPC+DIM, SPC+this.idx*DIM+DIM);
        	g2d.drawLine(SPC, SPC+this.idx*DIM+DIM, SPC+DIM, SPC+this.idx*DIM);
        }else {
        	this.fig.paint(g, false);
        }
    }
}