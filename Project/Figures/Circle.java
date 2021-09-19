package figures;

import java.awt.*;

public class Circle extends Figure {
	//private Color ccolor;
    //private Color bcolor;

    public Circle (int x, int y, int w, int h) {
        super(x,y,w,h);
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
        g2d.drawOval(this.x,this.y, this.w,this.h);
        //g2d.setColor(this.bcolor);
        //g2d.fillOval(this.x,this.y, this.w,this.h);
    }
}
