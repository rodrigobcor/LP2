package figures;

import java.awt.*;

public class Arc extends Figure {
    public Arc (int x, int y, int w, int h, int a1, int a2, Color ccolor, Color bcolor) {
        super(x,y,w,h,ccolor,bcolor);
        this.a1 = a1;
        this.a2 = a2;
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.ccolor);
        g2d.drawArc(this.x,this.y, this.w,this.w, this.a1,this.a2);
        g2d.setColor(this.bcolor);
        g2d.fillArc(this.x,this.y, this.w,this.w, this.a1,this.a2);
    }
}
