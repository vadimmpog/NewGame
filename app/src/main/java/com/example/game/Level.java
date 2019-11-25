package com.example.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Level extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_);
    }
    public void MainMenue(){
        setContentView(R.layout.main_activity);
    }

    @Override
    public void onClick(View v) {
        System.out.println(v.getX());
        System.out.println(v.getY());
    }
}
