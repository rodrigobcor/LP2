package figures;

import java.awt.*;

public class Rect {
    private int x, y;
    private int w, h;
    private Color ccolor;
    private Color bcolor;

    public Rect (int x, int y, int w, int h, Color ccolor, Color bcolor) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.ccolor = ccolor;
        this.bcolor = bcolor;
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.ccolor);
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(this.bcolor);
        g2d.fillRect(this.x+1,this.y+1, this.w-1,this.h-1);
    }
}
