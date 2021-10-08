#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//figure

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);
typedef int  (* Figure_Multiply)  (struct Figure*);

typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
    int (* multiply) (struct Figure*); //multiplica a area por 2-5
} Figure_vtable;

typedef struct Figure {
    int x, y, r;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

// rect

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) e area (%d).\nArea multiplicada por (%d) fica (%d).\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup),
           sup->r, sup->vtable->multiply(sup));
}

int rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}

int rect_multiply (Rect* this) {
    Figure* sup = (Figure*) this;
    sup->r = (rand() % 3)+2;
    return rect_area(this) * sup->r;
}

Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  rect_area,
    (Figure_Multiply)  rect_multiply
};

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

// ellipse

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d) e area (%d).\nArea multiplicada por (%d) fica (%d).\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->r, sup->vtable->multiply(sup));
}

int ellipse_area (Ellipse* this) {
    Figure* sup = (Figure*) this;
    return ((this->w/2)*((this->h/2))/((atan(1)*4)));
}

int ellipse_multiply (Ellipse* this) {
    Figure* sup = (Figure*) this;
    sup->r = (rand() % 3)+2;
    return ellipse_area(this) * sup->r;
}

Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area)  ellipse_area,
    (Figure_Multiply)  ellipse_multiply
};

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

// triangle

typedef struct {
    Figure super;
    int w, h;
} Triangle;

void triangle_print (Triangle* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de base (%d), altura (%d) na posicao (%d,%d) e area (%d).\nArea multiplicada por (%d) fica (%d).\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->r, sup->vtable->multiply(sup));
}

int triangle_area (Triangle* this) {
    Figure* sup = (Figure*) this;
    return ((this->w * this->h)/2);
}

int triangle_multiply (Triangle* this) {
    Figure* sup = (Figure*) this;
    sup->r = (rand() % 3)+2;
    return triangle_area(this) * sup->r;
}

Figure_vtable triangle_vtable = {
    (Figure_Print) triangle_print,
    (Figure_Area)  triangle_area,
    (Figure_Multiply)  triangle_multiply
};

Triangle* triangle_new (int x, int y, int w, int h) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->vtable = &triangle_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

// arc

typedef struct {
    Figure super;
    int w, h;
    int a1, a2;
} Arc;

void arc_print (Arc* this) {
    Figure* sup = (Figure*) this;
    printf("Arco de tamanho (%d,%d) na posicao (%d,%d), com angulo de (%d) e area (%d).\nArea multiplicada por (%d) fica (%d).\n",
           this->w, this->h, sup->x, sup->y, (this->a2-this->a1), sup->vtable->area(sup), sup->r, sup->vtable->multiply(sup));
}

int arc_area (Arc* this) {
    Figure* sup = (Figure*) this;
    return (((this->w)^2)*(this->a2-this->a1)*(atan(1)*4));
}

int arc_multiply (Arc* this) {
    Figure* sup = (Figure*) this;
    sup->r = (rand() % 3)+2;
    return arc_area(this) * sup->r;
}

Figure_vtable arc_vtable = {
    (Figure_Print) arc_print,
    (Figure_Area)  arc_area,
    (Figure_Multiply)  arc_multiply
};

Arc* arc_new (int x, int y, int w, int h, int a1, int a2) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->vtable = &arc_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->a1 = a1;
    this->a2 = a2;
}

// main

void main (void) {
    Figure* figs[8] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) triangle_new(100,100,100,150),
        (Figure*) arc_new(300,110,230,230,10,40),
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(210,110,305,130),
        (Figure*) triangle_new(150,150,200,100),
        (Figure*) arc_new(350,300,130,130, 10,40),
    };

    for (int i=0; i<8; i++) {
        figs[i]->vtable->print(figs[i]);
    }

    for (int i=0; i<8; i++) {
        free(figs[i]);
    }
}
