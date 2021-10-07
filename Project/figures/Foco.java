package figures;

import java.awt.*;

public class Foco extends Figure {
    public Foco (int x, int y, int w, int h, Color ccolor) {
        super(x,y,w,h,ccolor,null);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.ccolor);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
