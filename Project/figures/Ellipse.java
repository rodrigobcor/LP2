package figures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure {
    public Ellipse (int x, int y, int w, int h, Color ccolor, Color bcolor) {
        super(x,y,w,h,ccolor,bcolor);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.ccolor);
        g2d.draw(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
        g2d.setColor(this.bcolor);
        g2d.fill(new Ellipse2D.Double(this.x,this.y, this.w,this.h));
    }
}
