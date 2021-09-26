package figures;

import java.awt.*;

public class Arc extends Figure {
    public Arc (int x, int y, int w, int h, int a1, int a2) {
        super(x,y,w,h);
        this.a1 = a1;
        this.a2 = a2;
    }

    public void print () {
        System.out.format("Circulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawArc(this.x,this.y, this.w,this.h, this.a1,this.a2);
    }
}
