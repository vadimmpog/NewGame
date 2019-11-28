package com.example.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;



public class MyView extends View    {

    int N = 10;
    int M =10;
    int k=0;
    int q=0;
    Slime slime = new Slime();
    Piece[] pices = new Piece[N];
    Spike[] spikes = new Spike[M];
    float Nx;
    float Ny;



    public void MakeObjects(){
        for(int i=0;i<N;i++){
            pices[i]=new Piece((float) Math.random()*200+50,(float)Math.random()*200+50);
            pices[i].Vx=(int)(Math.random()*10-5);
            pices[i].Vy=(int)(Math.random()*10-5);
            pices[i].size=20;
        }
        for(int i=0;i<M;i++){
            spikes[i]=new Spike((int)( Math.random()*200+50),(int)(Math.random()*200+50));
            spikes[i].Vx=(int)(Math.random()*10-5);
            spikes[i].Vy=(int)(Math.random()*10-5);
            spikes[i].size=30;
            }
    }

    public void Compare(){
        for(int i=0;i<N;i++){
            if((slime.x>pices[i].x-pices[i].size&&slime.x<pices[i].x+pices[i].size)&&slime.y>pices[i].y-pices[i].size&&slime.y<pices[i].y+pices[i].size){
                pices[i].death=true;
                slime.PlusSize(1);
                q=0;
                for(int j=0;j<N;j++) {
                    if(pices[j].death)
                        q++;
                }
                if(q==N) k=N;
            }


        }
        for(int i=0;i<M;i++){
            if((slime.x>spikes[i].x-spikes[i].size&&slime.x<spikes[i].x+pices[i].size)&&slime.y>spikes[i].y-spikes[i].size&&slime.y<spikes[i].y+pices[i].size){
                spikes[i].killSlime(slime);
                k=-10;
            }
        }
    }

    void moveObjects() {
        for (int i = 0; i < N; i++) {
            pices[i].x+= pices[i].Vx;
            pices[i].y+= pices[i].Vy;
        }
        for (int i = 0; i < M; i++) {
            spikes[i].x+= spikes[i].Vx;
            spikes[i].y+= spikes[i].Vy;
        }
        Compare();

    }

    public MyView(Context context) {
        super(context);
        MakeObjects();
        MyTimer timer = new MyTimer();
        timer.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Ny=event.getY();
        Nx=event.getX();
        slime.setY(Ny);
        slime.setX(Nx);
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(k>=0&&k<N){
            Paint paint = new Paint();

            for (int i = 0; i < N; i++) {
                paint.setColor(Color.GREEN);
                if(!pices[i].death) canvas.drawCircle(pices[i].x, pices[i].y, pices[i].size, paint);

                if (pices[i].x-pices[i].size < 0 || pices[i].x+pices[i].size > this.getWidth()) {
                    pices[i].Vx = -pices[i].Vx;
                }
                if (pices[i].y-pices[i].size < 0 || pices[i].y+pices[i].size > this.getHeight()) {
                    pices[i].Vy = -pices[i].Vy;
                }
                if (pices[i].x < 0 || pices[i].x > this.getHeight()) {
                    pices[i].Vx = (float) (Math.random() * 8 + 2);
                    pices[i].Vy = (float) (Math.random() * 8 + 2);
                }
                pices[i].x += pices[i].Vx;
                pices[i].y += pices[i].Vy;
            }
            paint.setColor(Color.BLACK);
            for (int i = 0; i < M; i++) {
                canvas.drawCircle(spikes[i].x, spikes[i].y, spikes[i].size, paint);
                if (spikes[i].x-spikes[i].size < 0 || spikes[i].x+spikes[i].size > this.getWidth()) {
                    spikes[i].Vx = -spikes[i].Vx;
                }
                if (spikes[i].y-spikes[i].size < 0 || spikes[i].y+spikes[i].size > this.getHeight()) {
                    spikes[i].Vy = -spikes[i].Vy;
                }
                if (spikes[i].x < 0 || spikes[i].x > this.getHeight()) {
                    spikes[i].Vx = (float) (Math.random() * 8 + 2);
                    spikes[i].Vy = (float) (Math.random() * 8 + 2);
                }
                spikes[i].x += spikes[i].Vx;
                spikes[i].y += spikes[i].Vy;
            }

            Paint paint_slime  =new Paint();
            paint_slime.setColor(Color.GREEN);
            if(!slime.death)canvas.drawCircle(slime.x,slime.y,slime.size,paint_slime);
        }
        else{
            if(k==N){
                Paint paint = new Paint();
                paint.setColor(Color.BLACK);
                paint.setTextSize(100);
                canvas.drawText("YOU WIN!",this.getWidth()/4,this.getHeight()/2,paint);
            }
            if(k==-10){
                Paint paint = new Paint();
                paint.setColor(Color.BLACK);
                paint.setTextSize(100);
                canvas.drawText("YOU LOSE!",this.getWidth()/4,this.getHeight()/2,paint);
            }


        }


    }

    void nextFrame( ) {
        moveObjects();
        invalidate();
    }

    class MyTimer extends CountDownTimer {
        MyTimer() {
            super(1000000, 20);
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
