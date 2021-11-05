import ivisible.IVisible;
import figures.Figure;
import java.awt.*;

public class Button implements IVisible {
    static int SPC = 20;
    static int DIM = 25;
    static int PAD = 4;

    public  int    idx;
    public Figure fig;

    public Button (int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        this.fig.x = PAD+SPC;
        this.fig.y = PAD+SPC + idx*DIM+20;
        this.fig.w = DIM-PAD*2;
        this.fig.h = DIM-PAD*2;
    }

	public boolean clicked (int x, int y) {
        return SPC<=x && x<=SPC+DIM && SPC+this.idx*DIM<=y && y<=SPC+this.idx*DIM+DIM;
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(focused ? Color.GRAY : Color.LIGHT_GRAY);
        g2d.fillRect(SPC, SPC+this.idx*DIM+20, DIM, DIM);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(SPC, SPC+this.idx*DIM+20, DIM, DIM);

        this.fig.paint(g, false);
    }
}