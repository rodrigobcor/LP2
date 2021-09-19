package figures;

import java.awt.*;

public class Arc extends Figure {
    //private Color ccolor;
    //private Color bcolor;
    public Arc (int x, int y, int w, int h, int a1, int a2) {
        super(x,y,w,h);
        this.a1 = a1;
        this.a2 = a2;
        //this.ccolor = ccolor;
        //this.bcolor = bcolor;
    }

    public void print () {
        System.out.format("Circulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setColor(this.ccolor);
        g2d.drawArc(this.x,this.y, this.w,this.h, this.a1,this.a2);
        //g2d.setColor(this.bcolor);
        //g2d.fillArc(this.x,this.y, this.w,this.h, this.a1,this.a2);
    }
}
