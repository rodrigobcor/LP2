package figures;

import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public abstract class Figure {
    public int x, y;
    public int w, h;
    public int a1, a2;
    Color ccolor;
    Color bcolor;

    public Figure (int x, int y, int w, int h, Color ccolor, Color bcolor) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.a1 = a1;
        this.a2 = a2;
        this.ccolor = ccolor;
        this.bcolor = bcolor;
    }

    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public abstract void paint (Graphics g);

    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
}
