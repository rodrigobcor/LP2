#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Circle;

void Circle_print (Circle* this) {
    Figure* sup = (Figure*) this;
    printf("Circulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Circle* circle_new (int x, int y, int w, int h) {
    Circle* this = malloc(sizeof(Circle));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Circle_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Arc;

void Arc_print (Arc* this) {
    Figure* sup = (Figure*) this;
    printf("Arco de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Arc* arc_new (int x, int y, int w, int h) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Arc_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[8] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) circle_new(100,100,100,100),
        (Figure*) arc_new(300,110,305,130),
        (Figure*) circle_new(150,100,100,100),
        (Figure*) arc_new(350,300,305,130),
    };

    ///

    for (int i=0; i<8; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<8; i++) {
        free(figs[i]);
    }
}
