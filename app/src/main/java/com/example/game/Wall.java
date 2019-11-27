package com.example.game;

import android.graphics.Canvas;
import android.graphics.Paint;


public class Wall {
    public Wall(){ }

    boolean orientation;
    float x1;
    float x2;
    float y1;
    float y2;

    public void setOrientation(boolean orientation) {
        this.orientation = orientation;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }

    public void drawWall(Canvas canvas, Paint paint){
        canvas.drawRect(x1,y1,x2,y2,paint);
    }

}
