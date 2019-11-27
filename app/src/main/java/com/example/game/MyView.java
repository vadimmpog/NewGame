package com.example.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MyView extends View {

    Slime slime=new Slime();
    float g= 0.6f;
    float k= 0;
    float Nx;
    float Ny;
    static int N=9;
    Wall[] W = new Wall[N];

    public MyView(Context context) {
        super(context);
        MyTimer timer = new MyTimer();
        timer.start();

    }

    public void DrawWalls(Canvas canvas,Paint paint){
        for(int i=0;i<N;i++){
            W[i]=new Wall();
        }
        W[0].setOrientation(false);
        W[0].setX1(0);
        W[0].setX2(this.getWidth()/2);
        W[0].setY1(this.getHeight()/3*2-10);
        W[0].setY2(this.getHeight()/3*2+10);
        W[1].setOrientation(false);
        W[1].setX1(this.getWidth()/2);
        W[1].setX2(this.getWidth());
        W[1].setY1(this.getHeight()/3*2-10);
        W[1].setY2(this.getHeight()/3*2+10);//ворота
        W[2].setOrientation(true);
        W[2].setX1(this.getWidth()/3*2-10);
        W[2].setX2(this.getWidth()/3*2+10);
        W[2].setY1(this.getHeight()/3);
        W[2].setY2(this.getHeight()/12*9);
        W[3].setOrientation(true);
        W[3].setX1(this.getWidth()/3*2-10);
        W[3].setX2(this.getWidth()/3*2+10);
        W[3].setY1(this.getHeight()/12*10);
        W[3].setY2(this.getHeight());
        W[4].setOrientation(true);
        W[4].setX1(this.getWidth()/3-10);
        W[4].setX2(this.getWidth()/3+10);
        W[4].setY1(this.getHeight()/2);
        W[4].setY2(this.getHeight()/3*2+90);
        W[5].setOrientation(false);
        W[5].setX1(80);
        W[5].setX2(this.getWidth()/3+10);
        W[5].setY1(this.getHeight()/3*2+100);
        W[5].setY2(this.getHeight()/3*2+80);
        W[6].setOrientation(true);
        W[6].setX1(80);
        W[6].setX2(100);
        W[6].setY1(this.getHeight()/3*2+100);
        W[6].setY2(this.getHeight()-80);
        W[7].setOrientation(true);
        W[7].setX1(this.getWidth()/9*2);
        W[7].setX2(this.getWidth());
        W[7].setY1(this.getHeight()/3-10);
        W[7].setY2(this.getHeight()/3+10);
        W[8].setOrientation(true);
        W[8].setX1(this.getWidth()/3-10);
        W[8].setX2(this.getWidth()/3+10);
        W[8].setY1(this.getHeight()/12*11);
        W[8].setY2(this.getHeight());
        for(int i=0;i<N;i++){
            W[i].drawWall(canvas,paint);
        }
    }

    void compare(){
        if(slime.x+slime.size>this.getWidth()||slime.x<slime.size){
            slime.vX=0;
            g=0;
        }
        if(slime.y+slime.size>this.getHeight()||slime.y<slime.size){
            slime.vY=0;
            g=0;
        }
        //0
        if(((slime.x+slime.size>0)&&(slime.x-slime.size<this.getWidth()/2))&&((slime.y+slime.size>this.getHeight()/3*2-10)&&(slime.y-slime.size<this.getHeight()/3*2+10))) {
            if(slime.vY>-0.1&&slime.vY<0.1) {
                g = 0;
                k = 1f;
                slime.vY = 0;
                if (slime.vX >= -0.5 && slime.vX <= 0.5) {
                    slime.vX = 0;
                    k = 0;
                }
            }
            slime.vY *= -0.8;
        }
        //1
        if(((slime.x+slime.size>this.getWidth()/2)&&(slime.x-slime.size<this.getWidth()))&&((slime.y+slime.size>this.getHeight()/3*2-10)&&(slime.y-slime.size<this.getHeight()/3*2+10))) {
            if(slime.vY>-0.1&&slime.vY<0.1){
                g=0;
                k= 1f;
                slime.vY=0;
                if (slime.vX >= -0.5 && slime.vX <= 0.5) {
                    slime.vX = 0;
                    k = 0;
                }
            }
            slime.vY *= -0.8;
        }
        //2
        if(((slime.x+slime.size>this.getWidth()/3*2-10)&&(slime.x-slime.size<this.getWidth()/3*2+10))&&((slime.y+slime.size>this.getHeight()/3)&&(slime.y-slime.size<this.getHeight()/12*9))) {
            slime.vX *= -0.8;
        }
        //3
        if(((slime.x+slime.size>this.getWidth()/3*2-10)&&(slime.x-slime.size<this.getWidth()/3*2+10))&&((slime.y+slime.size>this.getHeight()/12*10)&&(slime.y-slime.size<this.getHeight()))) {
            slime.vX *= -0.8;
        }
        //4
        if(((slime.x+slime.size>this.getWidth()/3-10)&&(slime.x-slime.size<this.getWidth()/3+10))&&((slime.y+slime.size>this.getHeight()/2)&&(slime.y-slime.size<this.getHeight()/3*2+90))) {
            slime.vX *= -0.8;
        }
        //5
        if(((slime.x+slime.size>80)&&(slime.x-slime.size<this.getWidth()/3+10))&&((slime.y+slime.size>this.getHeight()/3*2+100)&&(slime.y-slime.size<this.getHeight()/3*2+80))) {
            if(slime.vY>-0.1&&slime.vY<0.1){
                g=0;
                k= 1f;
                slime.vY=0;
                if (slime.vX >= -0.5 && slime.vX <= 0.5) {
                    slime.vX = 0;
                    k = 0;
                }
            }
            slime.vY *= -0.8;
        }
        //6
        if(((slime.x+slime.size>80)&&(slime.x-slime.size<100))&&((slime.y+slime.size>this.getHeight()/3*2+100)&&(slime.y-slime.size<this.getHeight()-80))) {
            slime.vX *= -0.8;
        }
        //7
        if(((slime.x+slime.size>this.getWidth()/9*2)&&(slime.x-slime.size<this.getWidth()))&&((slime.y+slime.size>this.getHeight()/3-10)&&(slime.y-slime.size<this.getHeight()/3+10))) {
            if(slime.vY>-0.1&&slime.vY<0.1){
                g=0;
                k= 1f;
                slime.vY=0;
                if (slime.vX >= -0.5 && slime.vX <= 0.5) {
                    slime.vX = 0;
                    k = 0;
                }
            }
            slime.vY *= -0.8;
        }
        //8
        if(((slime.x+slime.size>this.getWidth()/3-10)&&(slime.x-slime.size<this.getWidth()/3+10))&&((slime.y+slime.size>this.getHeight()/12*11)&&(slime.y-slime.size<this.getHeight()))) {
            slime.vX *= -0.8;
        }
    }

    public void moveSlime( ){

        if(slime.vY<=10) slime.vY+=g;
        if(slime.vX<=-0.5&&slime.vY==0) slime.vX+=k;
        if(slime.vX>=0.5&&slime.vY==0) slime.vX-=k;
        slime.x+=slime.vX;
        slime.y+=slime.vY;
        compare();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint Wpaint =new Paint();
        Wpaint.setColor(Color.BLACK);
        Paint paint_slime  =new Paint();
        paint_slime.setColor(Color.GREEN);

        DrawWalls(canvas,Wpaint);

        canvas.drawCircle(slime.x,slime.y,slime.size,paint_slime);
    }

    void nextFrame( ) {
        moveSlime();
        invalidate();
    }

    class MyTimer extends CountDownTimer {
        MyTimer() {
            super(1000000, 1);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            nextFrame();
        }
        @Override
        public void onFinish() {
        }
    }
}
