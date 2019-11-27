package com.example.game;

public class Slime {
    public Slime(){
    }
    float size=25;
    float x=800;
    float y=500;
    float vX=0;
    float vY=0;
    float vJ=10;


    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    void shoot(float newx,float newy){
        float u;
        u=(float)Math.atan(Math.abs(newx-this.x)/Math.abs(newy-this.y));
        this.vY=vJ*(float)Math.cos(u);
        this.vX=vJ*(float)Math.sin(u);
    }
}
