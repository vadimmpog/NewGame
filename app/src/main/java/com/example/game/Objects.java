package com.example.game;

interface  Kill{
     void killSlime(Slime slime);
}

public abstract class Objects {
    private float x;
    private float y;
    float size;
    boolean death = false;

    public Objects(float x,float y){
        this.x=x;
        this.y=y;
    }

    public Objects(){}

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    abstract void die();

}
class Slime extends Objects{

    public Slime(){
        setX(1000);
        setY(500);
        this.size=25;
    }

    void die(){
        death = true;
    }

    public void PlusSize(float size) {
        this.size += size/2;
    }
}

class Piece extends Objects {
    float Vx;
    float Vy;

    public Piece(float x,float y) {
        super(x, y);
    }

    public void die() {
        death = true;
    }
}

class Spike extends Objects implements Kill{
    float Vx;
    float Vy;

    public Spike(float x, float y){
        super(x, y);
    }

    @Override
    public void killSlime(Slime slime) {
        slime.die();
    }

    @Override
    void die() {
        //immortal
    }
}

