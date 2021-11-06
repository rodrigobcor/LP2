#include <stdlib.h>
#include <stdio.h>
#include "rect.h"

typedef struct Rect {
    int x, y;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    printf("RECT (%d,%d) (%d,%d))\n", this->x, this->y, this->w, this->h);
}

Rect* rect_new (void) {
    Rect*   this  = malloc(sizeof(Rect));
    this->x = 0;
    this->y = 0;
    this->w = 10;
    this->h = 20;
}

void rect_drag (Rect* this, int dx, int dy) {
    this->x += dx;
    this->y += dy;
}


