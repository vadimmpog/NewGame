package com.example.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Level extends Activity implements View.OnTouchListener  {

    float Nx;
    float Ny;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
    @Override

    public boolean onTouch(View view, MotionEvent event) {
        Nx = event.getX();
        Ny = event.getY();
        Intent i = new Intent(Level.this,MyView.class);
        i.putExtra("x",Nx);
        i.putExtra("y",Ny);
        return true;
    }


    public void MainMenue(){
        setContentView(R.layout.main_activity);
    }



}
