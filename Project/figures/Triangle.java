package figures;

import java.awt.*;

public class Triangle extends Figure {
    public Triangle (int x, int y, int w, int h, Color ccolor, Color bcolor) {
        super(x,y,w,h,ccolor,bcolor);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int [] tx = {this.x, this.x+(this.w/2), this.x-(this.w/2)};
        int [] ty = {this.y-(this.h/2), this.y+(this.h/2), this.y+(this.h/2)};
        g2d.setColor(this.ccolor);
        g2d.drawPolygon(tx, ty, 3);
        g2d.setColor(this.bcolor);
        g2d.fillPolygon(tx, ty, 3);
    }
}
