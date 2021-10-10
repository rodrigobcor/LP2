package figures;

import java.awt.*;

public class Rect extends Figure {
    public Rect (int x, int y, int w, int h, Color ccolor, Color bcolor) {
        super(x,y,w,h,ccolor,bcolor);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.ccolor);
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(this.bcolor);
        g2d.fillRect(this.x,this.y, this.w,this.h);
    }
}
