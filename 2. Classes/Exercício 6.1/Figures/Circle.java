package figures;

import java.awt.*;

public class Circle extends Figure {
    public Circle (int x, int y, int w, int h) {
        super(x,y,w,h);
    }

    public void print () {
        System.out.format("Circulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}
