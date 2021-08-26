package figures;

import java.awt.*;

public class Arc {
    private int x, y;
    private int w, h;
    private int a1, a2;
    private Color ccolor;
    private Color bcolor;

    public Arc (int x, int y, int w, int h, int a1, int a2, Color ccolor, Color bcolor) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.a1 = a1;
        this.a2 = a2;
        this.ccolor = ccolor;
        this.bcolor = bcolor;
    }

    private void print () {
        System.out.format("Circulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.ccolor);
        g2d.drawArc(this.x,this.y, this.w,this.h, this.a1,this.a2);
        g2d.setColor(this.bcolor);
        g2d.fillArc(this.x,this.y, this.w,this.h, this.a1,this.a2);
    }
}
